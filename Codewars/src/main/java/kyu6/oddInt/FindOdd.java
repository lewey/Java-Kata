package kyu6.oddInt;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOdd {
    public static int findIt(int[] a) {
        // iterate over list assigning the value to a map
        return   Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);

        //check which entry set occurs an odd number of times.
    }

    public static int findItXOR(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        return xor;
    }
}
