package com.kata.findingPairs.streams;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;


/*
   Find the matching pairs that are multiple of 60.
   [20, 40, 60]  -> 1 as 20 + 40 is 60
   [60, 60, 60]  -> 3 as 60 +  60 = 120. 120 is a multiple of 60
 */

public class FindingPairs {

    public static int findPairCount(List<Integer> songDurations){

        final IntPredicate isMultipleOf60 = number -> number % 60 == 0;

        return IntStream.range(0, songDurations.size())
                .map(outerIndex -> IntStream.range(0, songDurations.size())
                        .filter(innerIndex -> innerIndex > outerIndex)
                        .map(innerIndex -> songDurations.get(outerIndex) + songDurations.get(innerIndex))
                        .filter(isMultipleOf60)
                        .map(CurrentIndex -> 1)
                        .sum())
                .sum();
    }
}
