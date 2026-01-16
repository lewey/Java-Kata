package com.kata.nameFilterAndCount;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NameFilterAndDistinctCount {

    public Map<String, Integer> performFilter(List<String> names, String prefix){
        final String lowerCasePrefix = prefix.toLowerCase();
        return  names.stream()
                .map(String::toLowerCase)
                .filter(name -> name.startsWith(lowerCasePrefix))
                .collect(Collectors.toMap(Function.identity(), name -> Math.toIntExact(name.chars().distinct().count())));
    }
}
