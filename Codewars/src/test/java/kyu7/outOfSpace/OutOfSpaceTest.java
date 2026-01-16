package kyu7.outOfSpace;

import kyu7.outOfSpace.OutOfSpace;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
  Kevin is noticing his space run out! Write a function that removes the spaces from the values and returns an array showing
  the space decreasing. For example, running this function on the array ['i', 'have','no','space'] would produce
  ['i','ihave','ihaveno','ihavenospace']
 */


public class OutOfSpaceTest {

    @Test
    public void test1() {
        String[] input = new String[]{"kevin", "has", "no", "space"};
        String[] expected = new String[]{"kevin", "kevinhas", "kevinhasno", "kevinhasnospace"};
        assertEquals(expected, OutOfSpace.spacey(input));
    }

    @Test
    public void test2() {
        String[] input = new String[]{"Camel", "Case", "Should", "Remain"};
        String[] expected = new String[]{"Camel", "CamelCase", "CamelCaseShould", "CamelCaseShouldRemain"};
        assertEquals(expected, OutOfSpace.spacey(input));
    }

    @Test
    public void test3() {
        String[] input = new String[]{"Trying!", "Adding2", "Diff3rent", "Comb1nati0ns"};
        String[] expected = new String[]{"Trying!", "Trying!Adding2", "Trying!Adding2Diff3rent", "Trying!Adding2Diff3rentComb1nati0ns"};
        assertEquals(expected, OutOfSpace.spacey(input));
    }
}
