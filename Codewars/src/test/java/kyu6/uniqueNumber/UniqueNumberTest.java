package kyu6.uniqueNumber;

/*
   There is an array with some numbers. All numbers are equal except for one. Try to find it!
   It’s guaranteed that array contains at least 3 numbers.
   The tests contain some very huge arrays, so think about performance.


 */


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  There is an array with some numbers. All numbers are equal except for one.
  Try to find it!
  It’s guaranteed that array contains at least 3 numbers.

  The tests contain some very huge arrays, so think about performance.
 */

public class UniqueNumberTest {

    private double precision = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1.0, UniqueNumber.findUniqueNumber(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, UniqueNumber.findUniqueNumber(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }

    @Test
    public void testDoublePrecision(){
        assertEquals(0.55, UniqueNumber.findUniqueNumber(new double[]{0, 0.55, 0}), precision);
        assertEquals(0.555, UniqueNumber.findUniqueNumber(new double[]{0.55, 0.55, 0.555}), precision);
    }

    @Test
    public void testNegativeNumbers(){
        assertEquals(-0.55, UniqueNumber.findUniqueNumber(new double[]{0.1, -0.55, 0.1}), precision);

    }

    @Test
    public void testDuplicates(){
        assertEquals(3, UniqueNumber.findUniqueNumber(new double[]{1, 1, 5, 3, 5}), precision);
    }

}
