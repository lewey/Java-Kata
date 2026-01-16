package com.kata.missingPositiveInt;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingPositiveNumber {
    public int getNextNumber(List<Integer> numbers){
        final List<Integer> positiveNumbersOnly = removeNonPositiveNumbers(numbers);
        return positiveNumbersOnly.size() == 0 ? 1 :  findNextPositiveInt(positiveNumbersOnly);
    }
    private int findNextPositiveInt(List<Integer> positiveNumbers){
        final int lastElement = positiveNumbers.stream()
                .mapToInt(num -> num)
                .max()
                .orElseThrow(NoSuchElementException::new);

        final boolean missingInternalNumbers = lastElement != positiveNumbers.size();
        return missingInternalNumbers ? findMissingInt(positiveNumbers) : lastElement + 1;
    }

    private List<Integer> removeNonPositiveNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(number -> number > 0)
                .collect(Collectors.toList());
    }

    private int findMissingInt(List<Integer> numbers) {

        final List<Integer> sortedList = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        return IntStream.range(1, sortedList.size() + 1)
            .filter(index -> index != sortedList.get(index - 1))
            .boxed()
            .findFirst()
            .orElseThrow(NoSuchElementException::new);
    }
}

/*
    Below is a way to find the missing int using external iteration
 */

//    private int findMissingInt(List<Integer> numbers) {
//
//        final List<Integer> sortedList = numbers.stream()
//                .sorted()
//                .collect(Collectors.toList());
//
//        int missingNumber = 0;
//
//        for (int i = 0; i <= sortedList.size(); i++) {
//            final int currentNum = sortedList.get(i);
//            final int nextNum = sortedList.get(i + 1);
//            final int expectedNextNum = currentNum + 1;
//
//            if (nextNum != expectedNextNum) {
//                missingNumber = expectedNextNum;
//                break;
//            }
//        }
//
//        return missingNumber;
//    }

