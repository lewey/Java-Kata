package com.kata.romanNumerals;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
    1 to 3 simply requires adding  I in a loop
    4 needs its own symbol
    5 needs its own symbol
    6 needs a symbol and 1 I
    7 needs a symbol and 2 I
    8 needs a symbol and 3 I
    9 needs its own symbol
    10 needs its own symbol
 */

public class RomanNumeral {

//    private static final int[] ARABIC_VALUES = {10, 9, 5, 4, 1};
//    private static final String[] ROMAN_NUMERAL_VALUES = {"X", "IX", "V", "IV", "I"};
//
//    public static String arabicToRoman(int arabicInputValue){
//
//        StringBuilder result = new StringBuilder();
//        int remaining = arabicInputValue;
//
//        for(int i = 0; i < ARABIC_VALUES.length; i++){
//            remaining = appendRomanNumerals(remaining, ARABIC_VALUES[i], ROMAN_NUMERAL_VALUES[i], result);
//        }
//
//        return result.toString();
//    }
//
//    private static int appendRomanNumerals(int remaining, int arabicListValue, String romanNumeral, StringBuilder result){
//
//        while(remaining >= arabicListValue){
//            result.append(romanNumeral);
//            remaining -= arabicListValue;
//        }
//
//        return remaining;
//    }


    private static final Map<Integer, String> numeralConversions = Map.of(1,"I", 4, "IV", 5, "V", 9, "IX", 10, "X");

    private static AtomicInteger remainingValue = null;

    public static String arabicToRoman(int numberToConvert){
        remainingValue = new AtomicInteger(numberToConvert);

        return numeralConversions.entrySet().stream()
            .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
            .map(es -> generateRomanNumeral(remainingValue.get(), es))
            .collect(Collectors.joining(""));
    }

    private static String generateRomanNumeral(int numberToConvert, Map.Entry<Integer, String> entrySet){
        if (numberToConvert < entrySet.getKey()){
            return "";
        } else{
            return performReduction(numberToConvert, entrySet.getKey(), entrySet.getValue());
        }
    }

    private static String performReduction(int numberToConvert, int currentNumeralValue, String updatedRomanNumeral){
        if(numberToConvert == currentNumeralValue){
            remainingValue.set(0);
            return updatedRomanNumeral;
        }else{
            return performReduction(numberToConvert - 1, currentNumeralValue, updatedRomanNumeral.concat("I"));
        }
    }

}


