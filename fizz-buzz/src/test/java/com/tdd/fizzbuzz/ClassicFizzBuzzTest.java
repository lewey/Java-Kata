package com.tdd.fizzbuzz;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ClassicFizzBuzzTest {

    @Test
    public void testSingleRangeReturns1Number(){
        ClassicFizzBuzz fizzBuzz = new ClassicFizzBuzz();
        String result = fizzBuzz.calculate(1);
        assertEquals("1", result);
    }

    @Test
    public void testDoubleRangeReturnsTwoNumbers(){
        ClassicFizzBuzz fizzBuzz = new ClassicFizzBuzz();
        String result = fizzBuzz.calculate(2);
        assertEquals("1, 2", result);
    }

    @Test
    public void testThreeReturnsTwoNumbersAndFizz(){
        ClassicFizzBuzz fizzBuzz = new ClassicFizzBuzz();
        String result = fizzBuzz.calculate(3);
        assertEquals("1, 2, Fizz", result);
    }

    @Test
    public void testFourReturnsThreeNumbersAndFizz(){
        ClassicFizzBuzz fizzBuzz = new ClassicFizzBuzz();
        String result = fizzBuzz.calculate(4);
        assertEquals("1, 2, Fizz, 4", result);
    }

    @Test
    public void testFiveReturnsThreeNumbersOneFizzAndOneBuzz(){
        ClassicFizzBuzz fizzBuzz = new ClassicFizzBuzz();
        String result = fizzBuzz.calculate(5);
        assertEquals("1, 2, Fizz, 4, Buzz", result);
    }

    @Test
    public void testFifteenReturnsFizzBuzz(){
        ClassicFizzBuzz fizzBuzz = new ClassicFizzBuzz();
        String result = fizzBuzz.calculate(15);
        assertEquals("1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz", result);
    }
}
