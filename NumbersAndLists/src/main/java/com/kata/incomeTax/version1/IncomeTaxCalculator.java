package com.kata.incomeTax.version1;



import java.util.Arrays;
import java.util.List;

public class IncomeTaxCalculator {

    /*
       Factory would be used to create the Bands with their functions using config to populate the values
     */

    private static Band zeroTaxBand = new Band(income -> income <= 99, income -> 0);
    private static Band lowerTaxBand = new Band(income -> income >= 100,
                                                income -> income >= 200 ? 100 * 10 / 100 : (income - 100) * 10 / 100);
    private static Band uppertaxBand = new Band(income -> income >= 200,
                                                income -> (income - 200) * 20 / 100);

    private static List<Band> bands = Arrays.asList(zeroTaxBand, lowerTaxBand, uppertaxBand);

    public static int calculateIncomeTax(int income){
        return bands.stream()
                .parallel()
                .filter(taxBand -> taxBand.doesBandApply(income))
                .reduce(0, (incomeTaxAcc, currentBand) -> currentBand.calculateIncomeTax(income), Integer::sum);
    }
}