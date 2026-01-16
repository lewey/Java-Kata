package com.kata;

import com.kata.reducer.DynamicReducer;
import com.kata.reducer.Reducer;
import com.kata.models.EntityUpdate;
import com.kata.models.ExpressionType;
import com.kata.models.FundData;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;


public class Launcher {

    private final static Predicate<Map.Entry<String, EntityUpdate>> isDynamicExpressionType =
            mapEntry -> !mapEntry.getValue().getExpressionType().equals(ExpressionType.NONE);

    public static Map<String, FundData> standardReducerWithHardcodedGroupBy(final List<FundData> fundData){
        return Reducer.reduce(fundData);
    }

    public static final Map<String, FundData> expressionBasedDynamicAggregation(List<FundData> fundData,  Map<String, EntityUpdate> config){

        final boolean isDataCleansingRequired = config.entrySet().stream()
                .anyMatch(isDynamicExpressionType);

        if(isDataCleansingRequired){
            final List<FundData> updatedData = performDataCleansing(fundData, config);

            updatedData.forEach(fundDataEntry -> {
                //are keys extracted in the correct order
                final List<String> configKeys = config.keySet().stream().toList();
                final String fieldValue = ReflectionUtils.extractFieldValues(configKeys, fundDataEntry);
                fundDataEntry.setDynamicGroupByKey(fieldValue);
            });

            return DynamicReducer.reduce(updatedData);
        }

        return null;
    }

    public static Map<String, FundData> variableLengthDynamicAggregation(List<FundData> fundData, List<String> config){
        fundData.forEach(fundDataEntry -> {
            final String fieldValue = ReflectionUtils.extractFieldValues(config, fundDataEntry);
            fundDataEntry.setDynamicGroupByKey(fieldValue);
        });

        return DynamicReducer.reduce(fundData);
    }

    private static List<FundData> performDataCleansing(List<FundData> fundData, Map<String, EntityUpdate> config) {

        // get a list of the config fields that need map to data fields that need to be updated
        final List<Map.Entry<String, EntityUpdate>> entitiesToUpdate = config.entrySet().stream()
                .filter(isDynamicExpressionType)
                .toList();

        // for each data object test to see if the specified fields, depicted above need updating, if so update them.
        return fundData.stream()
                .map(currentFundData -> {
                    // loop over the fields that require updating
                    entitiesToUpdate
                            .forEach(entry -> {
                                // use reflection to get the field value
                                final String fieldValue = ReflectionUtils.extractFieldValue(entry.getKey(), currentFundData);

                                // test the field name
                                final BiPredicate<String, String> function = getEntityPredicate(entry.getValue());
                                final String expressionValue = entry.getValue().getExpressionValue().orElse("");
                                if(function.test(fieldValue, expressionValue)){
                                    updateValue(currentFundData, entry.getKey(), expressionValue); // will need to remove Optional
                                }
                            });
                    return currentFundData;
                }).toList();
    }

    //this belongs elsewhere, perhaps with the enum class or as a factory
    private static BiPredicate<String, String> getEntityPredicate(EntityUpdate entityUpdate) {
       return String::startsWith; // poc
    }


    private static void updateValue(FundData currentFundData, String fieldToSet, String newValue){
        // may need to use a builder and make it dynamic
        ReflectionUtils.setValue(currentFundData, fieldToSet, newValue);
    }

}
