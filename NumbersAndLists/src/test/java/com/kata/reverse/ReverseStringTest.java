package com.kata.reverse;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringTest {

    @Test
    public void testReverseWithStringBuilderWillReverseAString(){
        final String inputString = "abc";
        final String reversedString = ReverseString.reverseWithStringBuilder(inputString);
        assertEquals("cba", reversedString);
    }


    @Test
    public void testReverseWithForLoopWillReverseAString(){
        final String inputString = "abc";
        final String reversedString = ReverseString.reverseWithForLoop(inputString);
        assertEquals("cba", reversedString);
    }

    @Test
    public void testReverseWithStringWillReverseAString(){
        final String inputString = "abc";
        final String reversedString = ReverseString.reverseWithString(inputString);
        assertEquals("cba", reversedString);
    }

    @Test
    public void testReverseWillReverseAString(){
        final String inputString = "abc";
        final String reversedString = ReverseString.reverse(inputString);
        assertEquals("cba", reversedString);
    }


}
