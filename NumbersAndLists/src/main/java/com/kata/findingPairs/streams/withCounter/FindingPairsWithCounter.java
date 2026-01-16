package com.kata.findingPairs.streams.withCounter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


/*
   Find the matching pairs that are multiple of 60.
   [20, 40, 60]  -> 1 as 20 + 40 is 60
   [60, 60, 60]  -> 3 as 60 +  60 = 120. 120 is a multiple of 60
 */

public class FindingPairsWithCounter {

    /*
        With this approach a counter is used to track the index so that unique pairs are found.
     */
    public static int findPairCount(List<Integer> songDurations){
        final AtomicInteger index = new AtomicInteger(0);

        // iterate through the entire list
        return songDurations.stream().mapToInt(currentDuration -> {
                    final int nextIndex = index.incrementAndGet();
                    // iterate through the remaining list with the help of the counter
                    return IntStream.range(nextIndex, songDurations.size())
                            .filter(currentIndex -> isMultipleOf60(songDurations.get(currentIndex) + currentDuration))
                            .map(CurrentIndex -> 1)
                            .sum();
                })
                .sum();
    }

    private static boolean isMultipleOf60(final int number){ return number % 60 == 0;};

}
