package com.kata;

import com.kata.models.FundData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionUtils {

    public static String extractFieldValues(List<String> keyFields, Object fundData){
        return keyFields.stream()
                .map(keyField -> "get".concat(capitalize(keyField)))
                .map(getFieldName -> extractGetMethod(fundData, getFieldName))
                .map(method -> invokeGetMethod(method, fundData))
                .collect(Collectors.joining(""));
    }

    public static String extractFieldValue(String keyField, Object fundData){
        final String fieldValue = "get".concat(capitalize(keyField));
        final Method method = extractGetMethod(fundData, fieldValue);
        return invokeGetMethod(method, fundData);
    }

    public static void setValue(FundData fundData, String fieldToSet, String newValue){
        final String fieldValue = "set".concat(capitalize(fieldToSet));
        final Method method = extractSetMethod(fundData, fieldValue);
        invokeSetMethod(method, fundData, newValue);
    }

    private static Method extractGetMethod(Object object, String fieldName) {
        try {
            return object.getClass().getDeclaredMethod(fieldName);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static Method extractSetMethod(Object object, String fieldName) {
        try {
            return object.getClass().getDeclaredMethod(fieldName, String.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static String invokeGetMethod(Method method, Object fundData) {
        try {
            return (String) method.invoke(fundData);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static void invokeSetMethod(Method method, Object fundData, String newValue) {
        try {
            method.invoke(fundData, newValue);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static String capitalize(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
