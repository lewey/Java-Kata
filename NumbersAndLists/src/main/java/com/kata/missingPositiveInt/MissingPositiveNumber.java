package com.kata.missingPositiveInt;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class MissingPositiveNumber {
    public int getNextNumber(List<Integer> numbers){
        final List<Integer> positiveNumbersOnly = removeNegativeNumbers(numbers);
        final int lastElement = positiveNumbersOnly.stream()
                .mapToInt(num -> num)
                .max().orElseThrow(NoSuchElementException::new);

        final boolean missingInternalNumbers = lastElement != positiveNumbersOnly.size();
        return missingInternalNumbers ? iterateForMissingInt(positiveNumbersOnly) : lastElement + 1;
    }

    private List<Integer> removeNegativeNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(number -> number > 0)
                .collect(Collectors.toList());
    }

    private int iterateForMissingInt(List<Integer> numbers){

        final List<Integer> sortedList = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        int missingNumber = 0;

        for(int i=0; i <= sortedList.size(); i++){
            final int currentNum = sortedList.get(i);
            final int nextNum = sortedList.get(i + 1);
            final int expectedNextNum = currentNum + 1;

            if(nextNum != expectedNextNum){
                missingNumber = expectedNextNum;
                break;
            }
        }
        return missingNumber;
    }
}
