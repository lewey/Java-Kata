package com.kata.missingPositiveInt;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class MissingPositiveNumberTest {

    @Test
    public void nextNumberReturnsMaxPlusOne(){
        MissingPositiveNumber missingPositiveNumber = new MissingPositiveNumber();
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int result = missingPositiveNumber.getNextNumber(numbers);

        assertEquals(4, result);
    }

    @Test
    public void nextNumberCanProcessZero(){
        MissingPositiveNumber missingPositiveNumber = new MissingPositiveNumber();
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3);
        int result = missingPositiveNumber.getNextNumber(numbers);

        assertEquals(4, result);
    }

    @Test
    public void nextNumberReturnsMaxPlusOneFromUnorderedList(){
        MissingPositiveNumber missingPositiveNumber = new MissingPositiveNumber();
        List<Integer> numbers = Arrays.asList(1, 3, 2);
        int result = missingPositiveNumber.getNextNumber(numbers);

        assertEquals(4, result);
    }

    @Test
    public void nextNumberReturnsNumberMissingWithinRange(){
        MissingPositiveNumber missingPositiveNumber = new MissingPositiveNumber();
        List<Integer> numbers = Arrays.asList(1, 3);
        int result = missingPositiveNumber.getNextNumber(numbers);

        assertEquals(2, result);
    }

    @Test
    public void nextNumberIgnoresZero(){
        MissingPositiveNumber missingPositiveNumber = new MissingPositiveNumber();
        List<Integer> numbers = Arrays.asList(-1, 0, 1);
        int result = missingPositiveNumber.getNextNumber(numbers);

        assertEquals(2, result);
    }

    @Test
    public void nextNumberIgnoresNegativeNumbers(){
        MissingPositiveNumber missingPositiveNumber = new MissingPositiveNumber();
        List<Integer> numbers = Arrays.asList(-3, -1, 1);
        int result = missingPositiveNumber.getNextNumber(numbers);

        assertEquals(2, result);
    }
}
