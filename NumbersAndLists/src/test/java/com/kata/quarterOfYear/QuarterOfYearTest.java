package com.kata.quarterOfYear;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuarterOfYearTest {

    @Test
    public void test1WillReturn1(){
        int value = QuarterOfYear.getQuarterForValue(1);
        assertEquals(1, value);
    }

    @Test
    public void test2WillReturn1(){
        int value = QuarterOfYear.getQuarterForValue(2);
        assertEquals(1, value);
    }

    @Test
    public void test3WillReturn1(){
        int value = QuarterOfYear.getQuarterForValue(3);
        assertEquals(1, value);
    }

    @Test
    public void test4WillReturn2(){
        int value = QuarterOfYear.getQuarterForValue(4);
        assertEquals(2, value);
    }

    @Test
    public void test6WillReturn2(){
        int value = QuarterOfYear.getQuarterForValue(6);
        assertEquals(2, value);
    }

    @Test
    public void test7WillReturn3(){
        int value = QuarterOfYear.getQuarterForValue(7);
        assertEquals(3, value);
    }

    @Test
    public void test9WillReturn3(){
        int value = QuarterOfYear.getQuarterForValue(9);
        assertEquals(3, value);
    }

    @Test
    public void test10WillReturn4(){
        int value = QuarterOfYear.getQuarterForValue(10);
        assertEquals(4, value);
    }

    @Test
    public void test12WillReturn4(){
        int value = QuarterOfYear.getQuarterForValue(12);
        assertEquals(4, value);
    }
}
