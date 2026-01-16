package com.kata.reverse;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReverseString {

    public static String reverseWithStringBuilder(String input){
        return new StringBuilder(input).reverse().toString();
    }


    public static String reverseWithForLoop(String input){;
        final char[] characters = input.toCharArray();
        final ArrayList<String> reveredCharacters = new ArrayList<>();

        for(int i = characters.length -1; i >= 0; i-- ){
           reveredCharacters.add(String.valueOf(characters[i]));
        }

        return String.join("", reveredCharacters);
    }

    public static String reverseWithString(String input){;
        final char[] characters = input.toCharArray();
        String output = "";

        for(int i = characters.length - 1; i >= 0; i-- ){
            output += characters[i];
        }

        return output;
    }

    public static String reverse(String input){

        return input.chars()                // Inputstream is the entry point
                .mapToObj(c -> (char) c)    // map to characters
                .reduce("",
                        (acc, currentCharacter) -> currentCharacter + acc, // Characters at this point, which are being reversed
                        (char1, char2) -> char1 + char2);  // combiner used to convert to Strings
    }
}
