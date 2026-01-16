package com.kata.findingPairs.tradationalLooping;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


/*
   Find the matching pairs that are multiple of 60.
   [20, 40, 60]  -> 1 as 20 + 40 is 60
   [60, 60, 60]  -> 3 as 60 +  60 = 120. 120 is a multiple of 60

   Below is the brute force approach
 */

public class FindingPairs {

    public static int findPairCount(List<Integer> songDurations){

        int pairMatchCount = 0;

        // loop of the entire list
        for(int i=0; i < songDurations.size(); i++){
            final int currentDuration = songDurations.get(i);
            //loop over the remainder of the list to see if the sum of other values is a multiple of 60
            int iterationCount = countPairs(songDurations, currentDuration, i);
            pairMatchCount += iterationCount;
        }

        return pairMatchCount;
    }

    private static int countPairs(List<Integer> songDurations, int currentDuration, int currentIndex){
        int currentPairCount = 0;

        for(int j=currentIndex+1; j < songDurations.size(); j++){
            int pairSummed = currentDuration + songDurations.get(j);
            if(isMultipleOf60(pairSummed)){
                currentPairCount++;

            }
        }

        return currentPairCount;
    }

    private static boolean isMultipleOf60(final int number){ return number % 60 == 0;};

}
