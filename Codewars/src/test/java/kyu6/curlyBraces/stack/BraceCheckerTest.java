package kyu6.curlyBraces.stack;
/*
Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.
This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!
All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.

"(){}[]"   =>  True
"([{}])"   =>  True
"(}"       =>  False
"[(])"     =>  False
"[({})](]" =>  False

*/


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BraceCheckerTest {
    private BraceChecker checker;

    @Before
    public void before(){
        checker = new BraceChecker();
    }

     @Test
     public void testValidParenthesis(){
         assertTrue(checker.isValid("()"));
     }

    @Test
    public void testInvalidSingleRightParenthesis() {
        assertFalse(checker.isValid(")"));
    }

    @Test
    public void testInvalidSingleLeftParenthesis() {
        assertFalse(checker.isValid("("));
    }

    @Test
    public void testNestedParenthesis() {
        assertTrue(checker.isValid("(())"));
    }

    @Test
    public void testValidSquare(){
        assertTrue(checker.isValid("[]"));
    }

    @Test
    public void testValidCurly(){
        assertTrue(checker.isValid("{}"));
    }

    @Test
    public void testValidNestedMix(){
        assertTrue(checker.isValid("{[([])]}"));
    }

    @Test
    public void testInValidNestedMix(){
        assertFalse(checker.isValid("[([]]}"));
    }

    @Test
    public void testInvalidSequence() {
        assertFalse(checker.isValid("[(])"));
    }

    @Test
    public void testValidSequence(){
        assertTrue(checker.isValid("()[]{}"));
    }

    @Test
    public void testNoRightBraces(){
        assertFalse(checker.isValid("(((({{"));
    }
}
