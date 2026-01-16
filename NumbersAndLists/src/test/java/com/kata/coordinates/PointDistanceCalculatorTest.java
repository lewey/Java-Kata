package com.kata.coordinates;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class PointDistanceCalculatorTest {

    @Test
    public void testCalculateDistancesfromZeroForASingleCoord(){
        final Coordinate coordinate = new Coordinate(1, 1);
        final Map<Coordinate, Double> result = PointDistanceCalculator.calculateDistancesfromZero(List.of(coordinate));

        Assert.assertEquals(Map.of(coordinate, 1.4142135623730951), result);
    }
}
