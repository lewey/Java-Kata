package com.kata.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClassicFizzBuzz {

    public String calculate(int rangeLimit){
        return IntStream.rangeClosed(1, rangeLimit)
                .mapToObj(this::numberToResult)
                .collect(Collectors.joining(", "));
    }

    private String numberToResult(int number){
        if(number % 15 == 0){
            return "FizzBuzz";
        } else if(number % 5 == 0){
            return "Buzz";
        }else if(number % 3 == 0){
            return "Fizz";
        }else{
            return String.valueOf(number);
        }
    }
}
