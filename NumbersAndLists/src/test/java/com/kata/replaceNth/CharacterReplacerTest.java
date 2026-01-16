package com.kata.replaceNth;

/*
   Task
      Write a method, that replaces every nth char oldValue with char newValue.

   Inputs
      text: the string to modify
      n: change the target letter every nth occurrencies
      old_value (or similar): the targetted character
      new_value (or similar): the character to use as replacement
      Note for untyped languages: all inputs are always valid and of their expected type.

    Rules
      Your method has to be case sensitive!
      If n is 0 or negative or if it is larger than the count of the oldValue, return the original text without a change.

    Example:
      n:         2
      old_value: 'a'
      new_value: 'o'
      "Vader said: No, I am your father!"
      1     2          3        4       -> 2nd and 4th occurence are replaced
      "Vader soid: No, I am your fother!"

      As you can see in the example: The first changed is the 2nd 'a'. So the start is always at the nth suitable char and not at the first!

 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterReplacerTest {

    private String originalMessage = "Vader said: No, I am your father!";

    @Test
    public void returnOriginalWhenNoOccurrence(){
        final String result = CharacterReplacer.replaceNth(originalMessage, '*', 'p', 1);
        assertEquals(originalMessage, result);
    }

    @Test
    public void returnOriginalWhenNIsNegative(){
        final String result = CharacterReplacer.replaceNth(originalMessage, '*', 'p', -1);
        assertEquals(originalMessage, result);
    }

    @Test
    public void returnOriginalWhenLargeOccurrence(){
        final String result = CharacterReplacer.replaceNth(originalMessage, 'a', 'o', 10);
        assertEquals(originalMessage, result);
    }

    @Test
    public void replaceEveryOccurrence(){
        final String result = CharacterReplacer.replaceNth(originalMessage, 'a', '*', 1);
        final String expectedMessage = "V*der s*id: No, I *m your f*ther!";
        assertEquals(expectedMessage, result);
    }

    @Test
    public void replaceEvery2ndOccurrence(){
        final String result = CharacterReplacer.replaceNth(originalMessage, 'a', '*', 2);
        final String expectedMessage = "Vader s*id: No, I am your f*ther!";
        assertEquals(expectedMessage, result);
    }

    //TODO loop

    @Test
    public void replaceEvery3rdOccurrence(){
        final String result = CharacterReplacer.replaceNth(originalMessage, 'a', '*', 3);
        final String expectedMessage = "Vader said: No, I *m your father!";
        assertEquals(expectedMessage, result);
    }

}
