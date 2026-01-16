package kyu7.digitInside;

import org.junit.Test;

import static kyu7.digitInside.DigitInside.numbersWithDigitInside;
import static org.junit.Assert.assertArrayEquals;

/*
    You have to search all numbers from inclusive 1 to inclusive a given number x, that have the given digit d in it.
    The value of d will always be 0 - 9.
    The value of x will always be greater than 0.

    You have to return as an array

    the count of these numbers,
    their sum
    and their product.
 */

public class DigitInsideTest {

    @Test
    public void BasicTests() {
        assertArrayEquals(new long[] { 0, 0, 0 }, numbersWithDigitInside(5, 6));
        assertArrayEquals(new long[] { 1, 6, 6 }, numbersWithDigitInside(7, 6));
        assertArrayEquals(new long[] { 3, 22, 110 }, numbersWithDigitInside(11, 1));
        assertArrayEquals(new long[] { 2, 30, 200 }, numbersWithDigitInside(20, 0));
        assertArrayEquals(new long[] { 9, 286, 5955146588160L }, numbersWithDigitInside(44, 4));
    }

}
