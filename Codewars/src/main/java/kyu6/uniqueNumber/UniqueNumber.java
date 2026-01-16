package kyu6.uniqueNumber;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueNumber {

    public static double findUniqueNumber(double[] numbers){
        return Arrays.stream(numbers)
                .parallel()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .mapToDouble(Map.Entry::getKey)
                .findFirst()
                .orElse(0.0);
    }
}
