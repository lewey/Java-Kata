package com.kata.newcastleSights;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
    Given an array of terms, if any of those terms relate to Newcastle upon Tyne, return Fog on the Tyne!
    The number of ! after the e should be determined by the number of Newcastle-upon- related terms you find in the provided array (x).
    The related terms are:

St James park
Big Market
Tyne Bridge
Monument
Millennium Bridge
The Sage
Theatre Royal
Greggs Sausage Roll

If you don't find any related terms, return 'No fog to be found here'


 */
public class NewcastleSightsTest {

    private int value = 2;
    private static final String NO_SIGHTS_FOUND = "No fog to be found here!";
    private static final String SIGHTS_FOUND = "Fog on the Tyne";


    @Test
    public void test(){
        assertEquals(2,value);
    }

    @Test
    public void testEmptyList(){
        String result = NewcastleSights.lookUpSights(Collections.emptyList());
        assertEquals(NO_SIGHTS_FOUND, result);
    }

    @Test
    public void testListContainingNonRelatedPhrases(){
        List<String> nonRelatedPhrases = Arrays.asList("Stadium of Light");

        String result = NewcastleSights.lookUpSights(nonRelatedPhrases);
        assertEquals(NO_SIGHTS_FOUND, result);
    }

    @Test
    public void testOneRelatedPhrase(){
        List<String> oneRelatedPhrase = Arrays.asList("Tyne Bridge");

        String result = NewcastleSights.lookUpSights(oneRelatedPhrase);
        assertEquals(SIGHTS_FOUND + "!", result);
    }

    @Test
    public void testTwoRelatedPhrase(){
        List<String> twoRelatedPhrase = Arrays.asList("Tyne Bridge", "The Sage");

        String result = NewcastleSights.lookUpSights(twoRelatedPhrase);
        assertEquals(SIGHTS_FOUND + "!!", result);
    }

    @Test
    public void testThreeRelatedPhrase(){
        List<String> threeRelatedPhrase = Arrays.asList("Tyne Bridge", "The Sage", "Monument");
        String result = NewcastleSights.lookUpSights(threeRelatedPhrase);
        assertEquals(SIGHTS_FOUND + "!!!", result);
    }

    @Test
    public void testMixedPhrase(){
        List<String> mixedPhrases = Arrays.asList("Tyne Bridge", "The Sage", "Tower Bridge");
        String result = NewcastleSights.lookUpSights(mixedPhrases);
        assertEquals(SIGHTS_FOUND + "!!", result);
    }

    @Test
    public void testDuplicates() {
        List<String> duplicates = Arrays.asList("Tyne Bridge", "Tyne Bridge");
        String result = NewcastleSights.lookUpSights(duplicates);
        assertEquals(SIGHTS_FOUND + "!", result);
    }
}