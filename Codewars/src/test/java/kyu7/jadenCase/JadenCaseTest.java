package kyu7.jadenCase;

import kyu7.jadenCase.JadenCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JadenCaseTest {

    /*
        Capitalise every word:

        Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
        Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
     */


    JadenCase jadenCase = new JadenCase();

    @Test
    public void test() {
        assertEquals("toJadenCase doesn't return a valid JadenCase String! try again please :)", "Most Trees Are Blue", jadenCase.toJadenCase("most trees are blue"));
    }

    @Test
    public void testNullArg() {
        assertNull("Must return null when the arg is null", jadenCase.toJadenCase(null));
    }

    @Test
    public void testEmptyArg() {
        assertNull("Must return null when the arg is empty string", jadenCase.toJadenCase(""));
    }

}
