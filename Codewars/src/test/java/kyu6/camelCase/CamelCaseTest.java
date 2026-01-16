package kyu6.camelCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  Complete the method/function so that it converts dash/underscore delimited words into camel casing.
  The first word within the output should be capitalized only if the original word was capitalized
  (known as Upper Camel Case, also often referred to as Pascal case). The next words should be always capitalized.
 */

public class CamelCaseTest {
    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "the_Stealth_Warrior";
        assertEquals("theStealthWarrior", CamelCase.toCamelCase(input));
    }
    @Test
    public void testSomeDashLowerStart() {
        String input = "the-Stealth-Warrior";
        assertEquals("theStealthWarrior", CamelCase.toCamelCase(input));
    }

    @Test
    public void testCapitalLetter() {
        String input = "The-Stealth-Warrior";
        assertEquals("TheStealthWarrior", CamelCase.toCamelCase(input));
    }

}

