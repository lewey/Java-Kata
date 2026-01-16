package kyu7.overTheRoad;

/*
    You've just moved into a perfectly straight street with exactly n identical houses on either
    side of the road. Naturally, you would like to find out the house number of the people on the
    other side of the street. The street looks something like this:

    1|   |6
    3|   |4
    5|   |2

    1|   |2

    1|   |4
    3|   |2


      Evens increase on the right; odds decrease on the left.
      House numbers start at 1 and increase without gaps.
      When n = 3, 1 is opposite 6, 3 opposite 4, and 5 opposite 2.

      Given your house number address and length of street n,
      give the house number on the opposite side of the street.

 */

import kyu7.overTheRoad.OverTheRoad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OverTheRoadTest {

   @Test
   public void oneRow(){
       final long result = OverTheRoad.overTheRoad(1, 3);
       assertEquals(6, result);
   }

    @Test
    public void basicTestCases() {
        assertEquals(6, OverTheRoad.overTheRoad(1, 3));
        assertEquals(4, OverTheRoad.overTheRoad(3, 3));
        assertEquals(5, OverTheRoad.overTheRoad(2, 3));
        assertEquals(8, OverTheRoad.overTheRoad(3, 5));
        assertEquals(16, OverTheRoad.overTheRoad(7, 11));
        assertEquals(1999981L, OverTheRoad.overTheRoad(20, 1000000));
        assertEquals(596421736780L, OverTheRoad.overTheRoad(23633656673L, 310027696726L));
    }

}
