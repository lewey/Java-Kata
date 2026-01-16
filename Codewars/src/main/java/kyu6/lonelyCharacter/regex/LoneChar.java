package kyu6.lonelyCharacter.regex;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

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

       final List<String> letters = Arrays.stream(trimmed.replaceAll("\\s*", "").split("")).toList();

       final Map<String, Integer> lettersWithCount = letters.stream()
               .collect(Collectors.toMap(
                       Function.identity(), letter -> countSpaces(letter, trimmed), (u, v) -> {
                           throw new IllegalStateException(String.format("Duplicate key %s", u));
                       }, LinkedHashMap::new));

        final int highestValue = lettersWithCount.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();

        return lettersWithCount.entrySet().stream()
                .filter(entry -> entry.getValue() == highestValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(""))
                .toCharArray();
    }


    private static int countSpaces(String letterToMatch, String text){
        final Pattern pattern = Pattern.compile("\\w?(\\s*" + letterToMatch + "\\s*)\\w?");
        final Matcher matcher = pattern.matcher(text);

        return matcher.find() ? matcher.group(1).length() - 1 : 0;
    }

    private static boolean spacesExist(String letters){
        return letters.contains(" ");
    }
}
