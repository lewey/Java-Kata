package com.kata;

import com.kata.models.EntityUpdate;
import com.kata.models.ExpressionType;
import com.kata.models.FundData;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LauncherTest {
    @Test
    public void testStandardReducerWithHardcodedGroupBy(){

        final FundData fundData1 = new FundData("F1", "I1", "USD", "3sample1", 5);
        final FundData fundData2 = new FundData("F1", "I1", "USD", "3sample1", 10);
        final FundData fundData3 = new FundData("F1", "I2", "USD", "4sample1", 16);
        final FundData fundData4 = new FundData("F1", "I2", "EUR", "4sample1", 20);
        final FundData fundData5 = new FundData("F1", "I3", "USD", "3sample1", 10);

        final List<FundData> fundData = List.of(fundData1, fundData2, fundData3, fundData4, fundData5);

        //fundId + investorId + currency + level1
        final Map<String, FundData> expectedMap = Map.of(
                "F1I1USD3sample1", new FundData("F1", "I1", "USD", "3sample1", 15),
                "F1I2USD4sample1", new FundData("F1", "I2", "USD", "4sample1", 16),
                "F1I2EUR4sample1", new FundData("F1", "I2", "EUR", "4sample1", 20),
                "F1I3USD3sample1", new FundData("F1", "I3", "USD", "3sample1", 10)
        );

        final Map<String, FundData> result = Launcher.standardReducerWithHardcodedGroupBy(fundData);

        assertEquals(expectedMap.keySet(), result.keySet());
        assertTrue(result.entrySet().stream()
                .allMatch(e -> e.getValue().equals(expectedMap.get(e.getKey()))));
    }


    @Test
    public void testVariableLengthDynamicAggregationTwo(){

        final List<String> config = List.of("fundId", "investorId");

        final FundData fundData1 = new FundData("F1", "I1", "USD", "3sample1", 5);
        final FundData fundData2 = new FundData("F1", "I1", "USD", "3sample1", 10);
        final FundData fundData3 = new FundData("F1", "I2", "USD", "4sample1", 16);
        final FundData fundData4 = new FundData("F1", "I3", "EUR", "4sample1", 20);

        final List<FundData> fundData = List.of(fundData1, fundData2, fundData3, fundData4);

        final Map<String, FundData> expectedMap = Map.of(
                "F1I1", new FundData("F1", "I1", "USD", "3sample1", 15),
                "F1I2", new FundData("F1", "I2", "USD", "4sample1", 16),
                "F1I3", new FundData("F1", "I3", "EUR", "4sample1", 20)
        );

        final Map<String, FundData> result = Launcher.variableLengthDynamicAggregation(fundData, config);

        assertEquals(expectedMap.keySet(), result.keySet());
        assertTrue(result.entrySet().stream()
                .allMatch(e -> e.getValue().equals(expectedMap.get(e.getKey()))));
    }

    @Test
    public void testVariableLengthDynamicAggregationThree(){

        final List<String> config = List.of("fundId", "investorId", "currency");

        final FundData fundData1 = new FundData("F1", "I1", "USD", "3sample1", 5);
        final FundData fundData2 = new FundData("F1", "I1", "USD", "3sample1", 10);
        final FundData fundData3 = new FundData("F1", "I1", "EUR", "3sample1", 10);
        final FundData fundData4 = new FundData("F1", "I2", "USD", "4sample1", 16);
        final FundData fundData5 = new FundData("F1", "I3", "EUR", "4sample1", 20);
        final FundData fundData6 = new FundData("F1", "I3", "USD", "3sample1", 10);

        final List<FundData> fundData = List.of(fundData1, fundData2, fundData3, fundData4, fundData5, fundData6);

        final Map<String, FundData> expectedMap = Map.of(
                "F1I1USD", new FundData("F1", "I1", "USD", "3sample1", 15),
                "F1I1EUR", new FundData("F1", "I1", "EUR", "3sample1", 10),
                "F1I2USD", new FundData("F1", "I2", "USD", "4sample1", 16),
                "F1I3EUR", new FundData("F1", "I3", "EUR", "4sample1", 20),
                "F1I3USD", new FundData("F1", "I3", "USD", "3sample1", 10)
        );

        final Map<String, FundData> result = Launcher.variableLengthDynamicAggregation(fundData, config);

        assertEquals(expectedMap.keySet(), result.keySet());
        assertTrue(result.entrySet().stream()
                .allMatch(e -> e.getValue().equals(expectedMap.get(e.getKey()))));
    }


    @Test
    public void testExpressionBasedDynamicAggregation(){

        final Map<String, EntityUpdate> config = new LinkedHashMap<>(Map.of("fundId", new EntityUpdate(ExpressionType.NONE),
                "investorId", new EntityUpdate(ExpressionType.NONE),
                "currency", new EntityUpdate(ExpressionType.NONE),
                "level1", new EntityUpdate(ExpressionType.CONTAINS, "3")));

        final FundData fundData1 = new FundData("F1", "I1", "USD", "3sample1", 5);
        final FundData fundData2 = new FundData("F1", "I2", "USD", "3sample2", 10);
        final FundData fundData3 = new FundData("F1", "I3", "USD", "4sample1", 16);
        final FundData fundData4 = new FundData("F1", "I3", "USD", "4sample1", 20);
        final FundData fundData5 = new FundData("F1", "I4", "USD", "3sample1", 10);
        final FundData fundData6 = new FundData("F1", "I4", "USD", "3sample1", 10);
        final FundData fundData7 = new FundData("F1", "I4", "EUR", "3sample3", 6);
        final FundData fundData8 = new FundData("F1", "I4", "EUR", "3sample4", 10);

        final List<FundData> fundData =
                List.of(fundData1, fundData2, fundData3, fundData4, fundData5, fundData6, fundData7, fundData8);

        final Map<String, FundData> expectedMap = Map.of(
                "F1I1USD3", new FundData("F1", "I1", "USD", "3", 5),
                "F1I2USD3", new FundData("F1", "I1", "USD", "3", 10),
                "F1I3USD4sample1", new FundData("F1", "I2", "USD", "4sample1", 36),
                "F1I4USD3", new FundData("F1", "I3", "USD", "3", 20),
                "F1I4EUR3", new FundData("F1", "I3", "EUR", "3", 16)
        );

        final Map<String, FundData> result = Launcher.expressionBasedDynamicAggregation(fundData, config);

        assertEquals(expectedMap.keySet(), result.keySet());
        assertTrue(result.entrySet().stream()
                .allMatch(e -> e.getValue().equals(expectedMap.get(e.getKey()))));
    }

}
