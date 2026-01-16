package kyu6.foxesAndChickens;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoxesAndChickensTest {

    @Test
    public void testFoxesInCages(){
        final String before = "..[CCCCF]F[FCCCC]";
        final String after  = "..[....F]F[F....]";
        assertEquals(after, FoxesAndChickens.hungryFoxes(before));
    }

    @Test
    public void testFoxOutSideCage(){
        final String before = "..C[CCCCC]FCC[CCCCC]..C";
        final String after  = "...[CCCCC]F..[CCCCC]...";
        assertEquals(after, FoxesAndChickens.hungryFoxes(before));
    }


    @Test
    public void ex1() {
        final String before = "CCC[CCC]FCC[CCCCC]CFFFF[CCC]FFFF";
        final String after  = "...[CCC]F..[CCCCC].FFFF[CCC]FFFF";
        assertEquals(after, FoxesAndChickens.hungryFoxes(before));
    }

    @Test
    public void ex2() {
        final String before = "...[CCC]...[CCCFC].....[CCC]....";
        final String after  = "...[CCC]...[...F.].....[CCC]....";
        assertEquals(after, FoxesAndChickens.hungryFoxes(before));
    }

    @Test
    public void ex3() {
        final String before = "CCC[CCC]FCC[CCCFC]CFFFF[CCC]FFFF";
        final String after  = "...[CCC]F..[...F.].FFFF[CCC]FFFF";
        assertEquals(after, FoxesAndChickens.hungryFoxes(before));
    }

    @Test
    public void random(){
        final String before = "..C.....FCCC.CC.CCCC.CCCC...CC...C.[C..C.C...C.F.]";
        final String after =  "........F..........................[...........F.]";
        assertEquals(after, FoxesAndChickens.hungryFoxes(before));
    }

    @Test
    public void random2(){
        final String before = "....C..C....C.CC.CCC.[...C....C..C.CC...CC..C]....C..CC[]F.C.C.CC..CCC[CC.FC........C.C..F....]";
        final String after =  ".....................[...C....C..C.CC...CC..C].........[]F............[...F..............F....]";
        assertEquals(after, FoxesAndChickens.hungryFoxes(before));
    }
}
