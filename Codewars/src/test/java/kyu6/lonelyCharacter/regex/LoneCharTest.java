package kyu6.lonelyCharacter.regex;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class LoneCharTest {

    @Test
    public void aSingleCharacter(){
        assertArrayEquals(new char[] { 'a' }, LoneChar.loneliest("a"));
    }

    @Test
    public void noSpaces(){
        assertArrayEquals(new char[] { 'b' }, LoneChar.loneliest("a b  c"));
    }

    @Test
    public void tests(){
        assertArrayEquals(new char[] { 'g' }, LoneChar.loneliest("abc d   ef  g   h i j      "));
        assertArrayEquals(new char[] { 'b' }, LoneChar.loneliest("a   b   c "));
        assertArrayEquals(new char[] { 'z' }, LoneChar.loneliest("  abc  d  z    f gk s "));
        assertArrayEquals(new char[] { 'b', 'c' }, LoneChar.loneliest("a  b  c  de  "));
    }

//    @Test
//    public void testFailure1(){
//        assertArrayEquals(new char[] { 'q' }, LoneChar.loneliest("  fh   mg       lrp     n a c     q    de    i  ok    b     j  "));
//    }
}
