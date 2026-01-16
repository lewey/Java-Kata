package medium.math.missingDigit;

/*
    Have the function MissingDigit(str) take the str parameter, which will be a simple mathematical formula with three numbers,
    a single operator (+, -, *, or /) and an equal sign (=) and return the digit that completes the equation.
    In one of the numbers in the equation, there will be an x character, and your program should determine what digit is missing.
    For example, if str is "3x + 12 = 46" then your program should output 4.
    The x character can appear in any of the three numbers and all three numbers will be greater than or equal to 0 and
    less than or equal to 1000000.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissingDigitTest {

    // ADDITION
    @Test
    public void testTdsSolution(){
        final String formula = "1 + 3 = x";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("4", result);
    }

    @Test
    public void testAdditionWithMissingResult(){
        final String formula = "1 + 3 = x";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("4", result);
    }

    @Test
    public void testAdditionWithMissingRightOperand(){
        final String formula = "3 + x = 10";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("7", result);
    }

    @Test
    public void testAdditionWithMissingRightOperandEmbedded(){
        final String formula = "22 + x = 28";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("6", result);
    }

    @Test
    public void testXWithinStandardResult(){
        final String formula = "10 + 3 = x3";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("1", result);
    }

    @Test
    public void testXWithinStandardResultAlternative(){
        final String formula = "100 * 3 = 3x0";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("0", result);
    }

    @Test
    public void testAdditionWithMissingLeftOperand(){
        final String formula = "x + 3 = 6";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("3", result);
    }

    @Test
    public void testAdditionWithMissingLeftOperandEmbedded(){
        final String formula = "1x + 2 = 15";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("3", result);
    }

    // SUBTRACTION

    @Test
    public void testSubtractionWithMissingResult(){
        final String formula = "3 - 1 = x";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("2", result);
    }

    @Test
    public void testSubtractionWithMissingLeftOperand(){
        final String formula = "x - 3 = 6";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("9", result);
    }

    @Test
    public void testSubtractionWithMissingLeftOperandEmbedded(){
        final String formula = "1x - 2 = 10";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("2", result);
    }

    @Test
    public void testSubtractionWithMissingRightOperand(){
        final String formula = "20 - x = 17";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("3", result);
    }

    @Test
    public void testSubtractionWithMissingRightOperandEmbedded(){
        final String formula = "120 - 1x0 = 20";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("0", result);
    }

    // MULTIPLICATION


    @Test
    public void testMultiplicationWithMissingResult(){
        final String formula = "3 * 3 = x";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("9", result);
    }

    @Test
    public void testMultiplicationWithMissingLeftOperand(){
        final String formula = "x * 3 = 30";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("10", result);
    }

    @Test
    public void testMultiplicationWithMissingLeftOperandEmbedded(){
        final String formula = "1x * 2 = 22";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("1", result);
    }

    @Test
    public void testMultiplicationWithMissingRightOperand(){
        final String formula = "20 * x = 60";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("3", result);
    }

    @Test
    public void testMultiplicationWithMissingRightOperandEmbedded(){
        final String formula = "44 * 1x = 528";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("2", result);
    }

    @Test
    public void testMultiplicationWithMissingRightOperandAndZeroResult(){
        final String formula = "4 * x = 0";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("0", result);
    }

    //DIVISION

    @Test
    public void testDivisionWithMissingResult(){
        final String formula = "3 / 3 = x";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("1", result);
    }

    @Test
    public void testDivisionWithMissingLeftOperand(){
        final String formula = "x / 3 = 10";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("30", result);
    }

    @Test
    public void testDivisionWithMissingLeftOperandEmbedded(){
        final String formula = "2x / 2 = 11";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("2", result);
    }

    @Test
    public void testDivisionWithMissingRightOperand(){
        final String formula = "20 / x = 5";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("4", result);
    }

    @Test
    public void testDivisionWithMissingRightOperandEmbedded(){
        final String formula = "100 / 1x = 10";
        final String result = MissingDigit.missingDigit(formula);
        assertEquals("0", result);
    }

//    @Test
//    public void testDivisionWithZero(){
//        final String formula = "0 / x = 0";
//        final String result = MissingDigit.MissingDigit(formula);
//        assertEquals("0", result);
//    }

}
