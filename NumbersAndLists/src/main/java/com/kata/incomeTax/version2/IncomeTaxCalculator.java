package com.kata.incomeTax.version2;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class IncomeTaxCalculator {

    /*
       Factory would be used to create the Bands with their functions using config to populate the values
     */

    private final static Band zeroTaxBand = new Band(0, 100, new BigDecimal("0.0"));
    private final static Band lowerTaxBand = new Band( 100, 200, new BigDecimal("10.0"));
    private final static Band uppertaxBand = new Band(200, new BigDecimal("20.0"));

    private static List<Band> bands = Arrays.asList(zeroTaxBand, lowerTaxBand, uppertaxBand);

    public static BigDecimal calculateIncomeTax(BigDecimal income){
        return bands.stream()
                .parallel()
                .filter(band -> band.isBandApplicable(income))
                .reduce(new BigDecimal("0.0"), (incomeTaxAcc, currentBand) -> currentBand.calculateIncomeTax(income), BigDecimal::add);
    }



}