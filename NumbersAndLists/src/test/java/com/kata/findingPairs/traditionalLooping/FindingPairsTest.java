package com.kata.findingPairs.traditionalLooping;

import com.kata.findingPairs.streams.FindingPairs;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindingPairsTest {

    @Test
    public void findPairCountsReturnsZeroForNoPairs(){
        final List<Integer> durations = Arrays.asList(41, 20, 60);
        final int pairResult = FindingPairs.findPairCount(durations);
        assertEquals(0, pairResult);
    }

    @Test
    public void findPairCountReturns1ForZeroRemainderPair(){
        final List<Integer> durations = Arrays.asList(60, 60);
        final int pairResult = FindingPairs.findPairCount(durations);
        assertEquals(1, pairResult);
    }

    @Test
    public void findPairCountReturns1ForSinglePair(){
        final List<Integer> durations = Arrays.asList(40, 20, 60);
        final int pairResult = FindingPairs.findPairCount(durations);
        assertEquals(1, pairResult);
    }

    @Test
    public void findPairCountReturnsTwoForPairs(){
        final List<Integer> durations = Arrays.asList(40, 20, 59, 1);
        final int pairResult = FindingPairs.findPairCount(durations);
        assertEquals(2, pairResult);
    }

    @Test
    public void findPairCountReturns3ForSharedPairs(){
        final List<Integer> durations = Arrays.asList(40, 20, 59, 1, 40);
        final int pairResult = FindingPairs.findPairCount(durations);
        assertEquals(3, pairResult);
    }

    @Test
    public void findPairCountReturns3ForThree60(){
        final List<Integer> durations = Arrays.asList(60, 60, 60);
        final int pairResult = FindingPairs.findPairCount(durations);
        assertEquals(3, pairResult);
    }

    @Test
    public void findPairCountSupportThree60sAndAlternativePair(){
        final List<Integer> durations = Arrays.asList(60, 60, 60, 20, 40);
        final int pairResult = FindingPairs.findPairCount(durations);
        assertEquals(4, pairResult);
    }

    @Test
    public void findPairsCountSupportsCombinationPairs(){
        final List<Integer> durations = Arrays.asList(60, 60, 60, 20, 40, 100);
        final int pairResult = FindingPairs.findPairCount(durations);
        assertEquals(5, pairResult);
    }
}
