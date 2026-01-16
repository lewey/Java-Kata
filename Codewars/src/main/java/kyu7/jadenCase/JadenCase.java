package kyu7.jadenCase;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/*
    Capitalise every word:

    Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
    Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
 */


public class JadenCase {

    public String toJadenCase(String phrase) {
        return isValid(phrase) ? performCaseTransform(phrase) : null;
    }

    private boolean isValid(String phrase){
        return !Objects.isNull(phrase) && !phrase.isEmpty();
    }

    private String performCaseTransform(String phrase){
        return Arrays.stream(phrase.split(" "))
                .map(this::capitiliseWord)
                .collect(Collectors.joining(" "));
    }

    private String capitiliseWord(String word){
        return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);
    }

}