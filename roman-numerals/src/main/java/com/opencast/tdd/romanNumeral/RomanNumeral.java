package com.opencast.tdd.romanNumeral;

public class RomanNumeral {

    private static final int[] ARABIC_VALUES = {10,9,5,4,1};
    private static final String[] ROMAN_NUMERAL_VALUES = {"X","IX","V","IV","I"};

    public static String arabicToRoman(int arabicInputValue){

        StringBuilder result = new StringBuilder();
        int remaining = arabicInputValue;

        for(int i = 0; i < ARABIC_VALUES.length; i++){
            remaining = appendRomanNumerals(remaining, ARABIC_VALUES[i], ROMAN_NUMERAL_VALUES[i], result);
        }

        return result.toString();
    }

    private static int appendRomanNumerals(int remaining, int arabicListValue, String romanNumeral, StringBuilder result){

        while(remaining >= arabicListValue){
            result.append(romanNumeral);
            remaining -= arabicListValue;
        }

        return remaining;
    }


}
