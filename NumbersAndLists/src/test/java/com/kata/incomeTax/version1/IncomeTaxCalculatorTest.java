package com.kata.incomeTax.version1;

import org.junit.Assert;
import org.junit.Test;

/*
    Calculate the income tax given a persons income

    If the income is less than 99 then no tax
    If income is between 100 and 200 then lower tax band which is 10%
    Anything above 200 is higher tax band at 20 %
 */

public class IncomeTaxCalculatorTest {

    @Test
    public void testNoTaxChargedForIncomeLessThan100(){
        final int salary = 99;
        final int taxAmount = IncomeTaxCalculator.calculateIncomeTax(salary);
        Assert.assertEquals(0, taxAmount);
    }

    @Test
    public void testTenPercentTaxBandWhenSalaryIsGreaterThan100(){
        final int salary = 110;
        final int taxAmount = IncomeTaxCalculator.calculateIncomeTax(salary);
        Assert.assertEquals(1, taxAmount);
    }

    @Test
    public void testTwentyPercentTaxBandWhenSalaryIsGreaterThan200(){
        final int salary = 400;
        final int taxAmount = IncomeTaxCalculator.calculateIncomeTax(salary);
        Assert.assertEquals(50, taxAmount);

    }

}
