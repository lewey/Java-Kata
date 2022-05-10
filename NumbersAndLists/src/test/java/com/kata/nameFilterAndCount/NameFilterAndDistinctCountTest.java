package com.kata.nameFilterAndCount;

/*
     Create a function that takes two parameters
     A list of names and a prefix to filter on.
     The function should return a map containing the name as the key and the count for the number of distinct characters
     as the value.

     names ->  lewey, lou, lew, jlew
     prefix -> lew

     = lewey:4, lew:3

     assume you can have an empty list but the prefix must have a valid string value that is not empty
     case can be ignored

 */

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class NameFilterAndDistinctCountTest {

    @Test
    public void testEmptyList(){
        final NameFilterAndDistinctCount filterAndCount = new NameFilterAndDistinctCount();
        final Map<String, Integer> result = filterAndCount.performFilter(Collections.EMPTY_LIST, "bob");
        assertEquals(Collections.EMPTY_MAP, result);
    }

    @Test
    public void testOneNameWithNonMatchingPrefix(){
        final NameFilterAndDistinctCount filterAndCount = new NameFilterAndDistinctCount();
        final Map<String, Integer> result = filterAndCount.performFilter(List.of("Percy"), "bob");
        assertEquals(Collections.EMPTY_MAP, result);
    }

    @Test
    public void testOneNameWithMatchingPrefix(){
        final NameFilterAndDistinctCount filterAndCount = new NameFilterAndDistinctCount();
        final Map<String, Integer> result = filterAndCount.performFilter(List.of("bob"), "bo");

        final Map<String, Integer> expectedResult = Map.of("bob", 2);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testMultipleNameWithMatchingPrefix(){
        final NameFilterAndDistinctCount filterAndCount = new NameFilterAndDistinctCount();
        final Map<String, Integer> result = filterAndCount.performFilter(List.of("bob", "jude", "bobby"), "bo");

        final Map<String, Integer> expectedResult = Map.of("bob", 2, "bobby", 3);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNameContainsButWithInvalidPrefix(){
        final NameFilterAndDistinctCount filterAndCount = new NameFilterAndDistinctCount();
        final Map<String, Integer> result = filterAndCount.performFilter(List.of("jbob"), "bob");
        assertEquals(Collections.EMPTY_MAP, result);
    }
}
