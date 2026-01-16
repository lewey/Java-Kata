package com.kata.incomeTax.version2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

public class Band {
    private final int startRange;
    private final Integer endRange;
    private final BigDecimal taxRate;

    public Band(final int startRange, final BigDecimal taxRate){
     this.startRange = startRange;
     this.taxRate = taxRate;
     this.endRange = null;
    }

    public Band(final int startRange, final int endRange, final BigDecimal taxRate){
        this.startRange = startRange;
        this.endRange = endRange;
        this.taxRate = taxRate;
    }

    public boolean isBandApplicable(BigDecimal income){
        return income.compareTo(BigDecimal.valueOf(startRange)) >= 0;
    }

    public BigDecimal calculateIncomeTax(BigDecimal income){
       final BigDecimal incomeToBeTaxed = calculateIncomeToBeTaxed(income);
        return incomeToBeTaxed.multiply((taxRate.divide(new BigDecimal("100"), RoundingMode.UP)));
    }

    private BigDecimal calculateIncomeToBeTaxed(BigDecimal income){
        return Optional.ofNullable(endRange)
                .filter(endRange -> income.compareTo(BigDecimal.valueOf(endRange)) > 0)
                .map(endRange -> BigDecimal.valueOf(endRange).subtract(BigDecimal.valueOf(startRange)))
                .orElseGet(() -> income.subtract(BigDecimal.valueOf(startRange)));
    }
}


