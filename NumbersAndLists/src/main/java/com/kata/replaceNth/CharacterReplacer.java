package com.kata.replaceNth;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharacterReplacer {

    public static String replaceNth(String originalText, char oldCharacter, char newCharacter, int occurrence){
        final long oldCharCount = originalText.chars().filter(currentCharacter -> currentCharacter == oldCharacter).count();
        final boolean isFilteringRequired = occurrence >= 0 && occurrence <= oldCharCount;

        return isFilteringRequired ? performFilter(originalText, oldCharacter, newCharacter, occurrence) : originalText;
    }

    private static String performFilter(String originalText, char oldCharacter, char newCharacter, int occurrence){
        final List<Character> allCharacters = originalText
                .chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());

        final List<Integer> oldCharacterIndexes = IntStream
                .range(0, originalText.length())
                .filter(currentIndex -> allCharacters.get(currentIndex) == oldCharacter)
                .boxed()
                .collect(Collectors.toList());

        final StringBuffer sb = new StringBuffer(originalText);

        IntStream.range(0, oldCharacterIndexes.size())
                .filter(currentIndex -> (currentIndex + 1) % occurrence == 0)
                .forEach(index -> sb.setCharAt(oldCharacterIndexes.get(index), newCharacter));

        return sb.toString();
    }
}
