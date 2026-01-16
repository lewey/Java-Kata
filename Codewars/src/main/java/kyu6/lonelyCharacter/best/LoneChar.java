package kyu6.lonelyCharacter.best;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LoneChar {

    public static char[] loneliest(String s) {
        var xs = Pattern.compile("(\\s*\\w)(?=(\\s*))").matcher(s.trim()).results().map(m -> m.group(1) + m.group(2)).toList();
        int maxLength = xs.stream().mapToInt(x -> x.length()).max().orElse(0);
        return xs.stream().filter(x -> x.length() == maxLength).map(x -> x.trim()).collect(Collectors.joining("")).toCharArray();
    }

    public static void main(String args[]){
        loneliest("  fh   mg       lrp     n a c     q    de    i  ok    b     j  ");
    }
}
