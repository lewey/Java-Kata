package com.kata.fizzbuzz.ocvariant;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void oneReturnsSingleStat(){
        Assert.assertEquals("1 \nnumber: 1", FizzBuzz.determineFizzBuzz(1));
    }

    @Test
    public void oneToThreeHasValidStats(){
        Assert.assertEquals("1 2 luck \nluck: 1\nnumber: 2", FizzBuzz.determineFizzBuzz(3));
    }

    @Test
    public void oneToFiveHasValidStats(){
        Assert.assertEquals("1 2 luck 4 buzz \nbuzz: 1\nluck: 1\nnumber: 3", FizzBuzz.determineFizzBuzz(5));
    }

    @Test
    public void oneToSixHasValidStats(){
        Assert.assertEquals("1 2 luck 4 buzz fizz \nfizz: 1\nbuzz: 1\nluck: 1\nnumber: 3", FizzBuzz.determineFizzBuzz(6));
    }

    @Test
    public void oneToFifteenHasValidStats(){
        Assert.assertEquals("1 2 luck 4 buzz fizz 7 8 fizz buzz 11 fizz luck 14 fizzbuzz \nfizz: 3\nbuzz: 2\nfizzbuzz: 1\nluck: 2\nnumber: 7", FizzBuzz.determineFizzBuzz(15));
    }

    @Test
    public void oneToTwentyHasValidStats(){
        Assert.assertEquals("1 2 luck 4 buzz fizz 7 8 fizz buzz 11 fizz luck 14 fizzbuzz 16 17 fizz 19 buzz \nfizz: 4\nbuzz: 3\nfizzbuzz: 1\nluck: 2\nnumber: 10", FizzBuzz.determineFizzBuzz(20));
    }


}
