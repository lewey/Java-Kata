package kyu6.lonelyCharacter.listIterator;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Predicate.not;

/*
    Complete the function which accepts a string and return an array of character(s) that have the most spaces to their right and left.

    Notes:

    the string can have leading/trailing spaces - you should not count them
    the strings contain only unique characters from a to z
    the order of characters in the returned array doesn't matter
 */
public class LoneChar {

    public static char[] loneliest(String s) {
       final String trimmed = s.trim();

       if(trimmed.length() == 1 || !spacesExist(trimmed)){
          return trimmed.toCharArray();
       }

       final Map<String, Integer> lettersWithIndexes = lettersWithIndex(trimmed);
       final List<String> lettersAndSpaces = Arrays.stream(trimmed.split("")).toList();

       final Map<String, Integer> lettersWithCount = lettersWithIndexes.entrySet().stream()
               .map(entry -> countSpaces(entry, lettersAndSpaces))
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

       final int highestValue = lettersWithCount.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();

       return lettersWithCount.entrySet().stream()
               .filter(entry -> entry.getValue() == highestValue)
               .map(Map.Entry::getKey)
               .collect(Collectors.joining(""))
               .toCharArray();
    }

    private static Map.Entry<String, Integer> countSpaces(Map.Entry<String, Integer> entry, List<String> lettersAndSpaces){
        final int totalSpaces = countForwardSpaces(entry.getValue(), lettersAndSpaces) + countBackwardSpaces(entry.getValue(), lettersAndSpaces);;
        return Map.entry(entry.getKey(), totalSpaces);
    }

    private static int countForwardSpaces(int index, List<String> lettersAndSpaces){
        int forwardSpaces = 0;
        final ListIterator<String> iterator = lettersAndSpaces.listIterator(index + 1);

        while(iterator.hasNext()){
            final String nextElement = iterator.next();
            if(nextElement.equals(" ")){
                forwardSpaces++;
            }else{
                break;
            }
        }

        return forwardSpaces;
    }

    private static int countBackwardSpaces(int index, List<String> lettersAndSpaces){
        int backwardSpaces = 0;

        if(index == 0){
            return backwardSpaces;
        }

        final ListIterator<String> iterator = lettersAndSpaces.listIterator(index);

        while(iterator.hasPrevious()){
            final String previousElement = iterator.previous();
            if(previousElement.equals(" ")){
                backwardSpaces++;
            }else{
                break;
            }
        }

        return backwardSpaces;
    }


    private static Map<String, Integer> lettersWithIndex(String lettersWithSpaces){
        return IntStream.range(0, lettersWithSpaces.length())
                .boxed()
                .filter(index -> !String.valueOf(lettersWithSpaces.charAt(index)).equals(" "))
                .collect(Collectors.toMap(index -> String.valueOf(lettersWithSpaces.charAt(index)), index -> index));
    }

    private static boolean spacesExist(String letters){
        return letters.contains(" ");
    }
}
