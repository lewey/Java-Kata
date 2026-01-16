package kyu7.overTheRoad;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.stream.LongStream.rangeClosed;

/*
    You've just moved into a perfectly straight street with exactly n identical houses on either
    side of the road. Naturally, you would like to find out the house number of the people on the
    other side of the street. The street looks something like this:

    1|   |2     n = 1   total Line = 3

    1|   |4     n = 2   total Line = 5
    3|   |2

    1|   |6     n = 3   total line = 7
    3|   |4
    5|   |2

    1|   |8     n = 4   total line = 9
    3|   |6
    5|   |4
    7|   |2

    To find the opposite   (n * 2) + 1 = row value

      Evens increase on the right; odds decrease on the left.
      House numbers start at 1 and increase without gaps.
      When n = 3, 1 is opposite 6, 3 opposite 4, and 5 opposite 2.

      Given your house number address and length of street n,
      give the house number on the opposite side of the street.

      This kata can't be solved with lists. It has to be maths.




 */

public class OverTheRoad {
    public static long overTheRoad(long address, long n) {
        return n*2 + 1 - address;
    }
}



/*
   public static long overTheRoad(long address, long n) {

        final  Map<Boolean, List<Long>> allAddresses = createAddressRows(n);
        final  List<Long> evenAddresses = allAddresses.get(true);
        final  List<Long> oddAddresses = allAddresses.get(false);

        //TODO this can be improved
        //Collections.reverse(oddAddresses);

        final boolean isAddressEven = isAddressEven(address);

        int currentAddressIndex = isAddressEven ? evenAddresses.indexOf(address) : oddAddresses.indexOf(address);
        return isAddressEven ? oddAddresses.get(currentAddressIndex) : evenAddresses.get(currentAddressIndex);
    }

    //TODO use longs not boxed
    private static Map<Boolean, List<Long>> createAddressRows(long amountOfRows){

       return LongStream.rangeClosed(1, amountOfRows * 2)
                .parallel()
                .boxed()
                .collect(Collectors.groupingBy(x -> x % 2 == 0));
    }

    private static boolean isAddressEven(long address){
        return address % 2 == 0;
    }
 */
