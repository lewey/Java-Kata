package com.kata.incomeTax.version1;

import java.util.function.Function;
import java.util.function.Predicate;

public class Band {
    private final Predicate<Integer> taxBandRange;
    private final Function<Integer, Integer> bandCalculation;

    public Band(final Predicate<Integer> taxBandRange, final Function<Integer, Integer> bandCalculation){
        this.taxBandRange = taxBandRange;
        this.bandCalculation = bandCalculation;
    }

    public boolean doesBandApply(int income){
        return taxBandRange.test(income);
    }


    public int calculateIncomeTax(int income){
        return bandCalculation.apply(income);
    }

}


