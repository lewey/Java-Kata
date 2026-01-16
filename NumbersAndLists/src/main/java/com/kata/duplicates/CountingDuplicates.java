package com.kata.duplicates;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingDuplicates {
    public static int duplicateCount(String message){
        return (int) message.toLowerCase().chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .filter(count -> count > 1)
                .count();
    }

    public static int duplicateCountWithChar(String message){
        return (int) message.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .filter(count -> count > 1)
                .count();
    }
}
