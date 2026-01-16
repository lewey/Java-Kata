package com.kata.findingPairs.efficient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


/*
   Find the matching pairs that are multiple of 60.
   [20, 40, 60]  -> 1 as 20 + 40 is 60

   [60, 60, 60]  -> 3 as 60 +  60 = 120. 120 is a multiple of 60

   A more efficient approach is to find uses the notion of checking if the second half of the pair has already been stored
   Given the example [20, 40, 60].
   On the first pass:

    20 will be stored in the memory and a check made for the complement 40 in the memory, not the rest of the list as this requires iteration.

   On the second pass:

    40 will be stored in the memory and a check for the complement 20. As this does exist the pair count is incremented.

   On the third pass:

   60 returns 0 on a modulus check and thus is a special case. If zero does not already exist then simply add it.
   If it does exist then we have a match, so we need to add the current frequency to the pair count. The frequency is then updated by one.

 */

public class FindingPairs {


    public static int findPairCount(List<Integer> songDurations){

        final Map<Integer, Integer> remainderFreq = new HashMap<>();
        final AtomicInteger pairCount = new AtomicInteger(0);

        for(int i=0; i < songDurations.size(); i++){
            final int currentDuration = songDurations.get(i);
            final int remainder = currentDuration % 60;

            if(remainder != 0){
                storeRemainderValue(remainderFreq, remainder);

                final int complementRemainder = 60 - remainder;
                if(remainderFreq.containsKey(complementRemainder)){
                    pairCount.getAndAdd(remainderFreq.get(complementRemainder));
                }

            }else{
                updateZeroRemainderValue(remainderFreq, pairCount);
            }
        }

        return pairCount.get();
    }

    private static void updateZeroRemainderValue(Map<Integer, Integer> remainderFreq, AtomicInteger pairCount){
        if(remainderFreq.containsKey(0)) {
            final int currentZeroFrequency = remainderFreq.get(0);
            pairCount.getAndAdd(currentZeroFrequency);
            remainderFreq.put(0, currentZeroFrequency + 1);
        } else {
            remainderFreq.put(0, 1);
        }
    }

    private static void storeRemainderValue(Map<Integer, Integer> remainderFreq, int remainder){
        if(remainderFreq.containsKey(remainder)) {
            final int currentFrequency = remainderFreq.get(remainder);
            remainderFreq.put(remainder, currentFrequency + 1);
        } else {
            remainderFreq.put(remainder, 1);
        }
    }

}
