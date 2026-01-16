package com.kata.reverse;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {
    public String spinWords(String sentence){
        return Arrays.stream(sentence.split("\\s+"))
                .map(word -> word.length() >= 5 ? new StringBuilder(word).reverse() : word)
                .collect(Collectors.joining(" "));
    }
}
