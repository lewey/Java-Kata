package com.opencast.tdd.romanNumeral;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTest {

    @Test
    public void oneReturnsOne(){
        String result = RomanNumeral.arabicToRoman(1);
        Assert.assertEquals("I", result);
    }

    @Test
    public void TwoReturnsTwo(){
        String result = RomanNumeral.arabicToRoman(2);
        Assert.assertEquals("II", result);
    }

    @Test
    public void ThreeReturnsThree(){
        String result = RomanNumeral.arabicToRoman(3);
        Assert.assertEquals("III", result);
    }

    @Test
    public void FourReturnsFour(){
        String result = RomanNumeral.arabicToRoman(4);
        Assert.assertEquals("IV", result);
    }

    @Test
    public void FiveReturnsFive(){
        String result = RomanNumeral.arabicToRoman(5);
        Assert.assertEquals("V", result);
    }

    @Test
    public void SixReturnsSix(){
        String result = RomanNumeral.arabicToRoman(6);
        Assert.assertEquals("VI", result);
    }

    @Test
    public void SevenReturnsSeven(){
        String result = RomanNumeral.arabicToRoman(7);
        Assert.assertEquals("VII", result);
    }

    @Test
    public void EightReturnsEight(){
        String result = RomanNumeral.arabicToRoman(8);
        Assert.assertEquals("VIII", result);
    }

    @Test
    public void NineReturnsNine(){
        String result = RomanNumeral.arabicToRoman(9);
        Assert.assertEquals("IX", result);
    }

    @Test
    public void TenReturnsTen(){
        String result = RomanNumeral.arabicToRoman(10);
        Assert.assertEquals("X", result);
    }

}
