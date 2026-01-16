package kyu6.camelCase;

import java.util.Arrays;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;

public class CamelCase {
    public static String toCamelCase(String s){
        if(s.equals("")){
            return s;
        }else{
            return Arrays.stream(s.split("_|-"))
                    .map(CamelCase::toUpper)
                    .collect(collectingAndThen(joining(""), str -> (isCapitalLetter(s))? str : toLower(str)));
        }
    }

    private static String toLower(String word){
        final String lowerCaseLetter = String.valueOf(word.charAt(0)).toLowerCase();
        return lowerCaseLetter + word.substring(1);
    }

    private static String toUpper(String word){
        final String upperCaseLetter = String.valueOf(word.charAt(0)).toUpperCase();
        return upperCaseLetter + word.substring(1);
    }

    private static boolean isCapitalLetter(String word){
        return Character.isUpperCase(word.charAt(0));
    }
}




/*

  static String toCamelCase(String str){
    String[] words = str.split("[-_]");
    return Arrays.stream(words, 1, words.length)
            .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
            .reduce(words[0], String::concat);
  }

  static String toCamelCase(String s){
    Matcher m = Pattern.compile("[_|-](\\w)").matcher(s);
    StringBuffer sb = new StringBuffer();
    while (m.find()) {
        m.appendReplacement(sb, m.group(1).toUpperCase());
    }
    return m.appendTail(sb).toString();
  }

 */