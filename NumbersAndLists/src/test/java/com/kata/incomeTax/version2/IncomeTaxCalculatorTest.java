package com.kata.incomeTax.version2;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/*
    Calculate the income tax given a persons income

    If the income is less than 99 then no tax
    If income is between 100 and 200 then lower tax band which is 10%
    Anything above 200 is higher tax band at 20 %
 */

public class IncomeTaxCalculatorTest {

    @Test
    public void testNoTaxChargedForIncomeLessThan100(){
        final BigDecimal salary = new BigDecimal("99.0");
        final BigDecimal taxAmount = IncomeTaxCalculator.calculateIncomeTax(salary);
        Assert.assertEquals(new BigDecimal("0.00"), taxAmount);
    }

    @Test
    public void testTenPercentTaxBandWhenSalaryIsGreaterThan100(){
        final BigDecimal salary = new BigDecimal("110.0");
        final BigDecimal taxAmount = IncomeTaxCalculator.calculateIncomeTax(salary);
        Assert.assertEquals(new BigDecimal("1.00"), taxAmount);
    }

    @Test
    public void testTwentyPercentTaxBandWhenSalaryIsGreaterThan200(){
        final BigDecimal salary = new BigDecimal("400.0");
        final BigDecimal taxAmount = IncomeTaxCalculator.calculateIncomeTax(salary);
        Assert.assertEquals(new BigDecimal("50.00"), taxAmount);

    }

}
