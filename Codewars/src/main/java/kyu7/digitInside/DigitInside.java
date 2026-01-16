package kyu7.digitInside;

import java.util.function.Supplier;
import java.util.stream.LongStream;

public class DigitInside {

    public static long[] numbersWithDigitInside(long upperBound, long digitToSearch) {
        final Supplier<LongStream> filteredValues = filteredValues(upperBound, String.valueOf(digitToSearch));
        final long count = filteredValues.get().count();
        final long sum = filteredValues.get().sum();
        final long product = filteredValues.get().reduce((x, y) -> x * y).orElse(0L);

        return new long[] {count, sum, product};
    }
    
    private static Supplier<LongStream> filteredValues(long upperBound, String digitToSearch){
        return () -> LongStream.rangeClosed(1, upperBound)
                .mapToObj(String::valueOf)
                .filter(digit -> digit.contains(digitToSearch))
                .mapToLong(Long::parseLong);
    }

}
