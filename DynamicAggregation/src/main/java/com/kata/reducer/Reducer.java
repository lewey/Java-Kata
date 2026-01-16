package com.kata.reducer;

import com.kata.models.FundData;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class Reducer {

    public static Map<String, FundData> reduce(List<FundData> fundDataList){
        return fundDataList.stream().collect(groupingBy(FundData::getGroupByKey, reducing(new FundData(), Reducer::reduceParts)));
    }

    private static FundData reduceParts(FundData f1, FundData f2){
        return new FundData(
                f2.getFundId(),
                f2.getInvestorId(),
                f2.getCurrency(),
                f2.getLevel1(),
                f1.getAmount() + f2.getAmount());
    }
}
