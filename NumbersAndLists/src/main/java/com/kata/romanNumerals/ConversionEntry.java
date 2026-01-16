package com.kata.romanNumerals;

public class ConversionEntry {

    private final int arabicValue;
    private final String romanNumeralValue;

    public ConversionEntry(final int arabicValue, final String romanNumeralValue) {
        this.arabicValue = arabicValue;
        this.romanNumeralValue = romanNumeralValue;
    }

    public int getArabicValue() {
        return arabicValue;
    }

    public String getRomanNumeralValue() {
        return romanNumeralValue;
    }
}
