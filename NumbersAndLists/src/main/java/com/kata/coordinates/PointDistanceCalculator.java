package com.kata.coordinates;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PointDistanceCalculator {

    /*
            d=√((x2 – x1)² + (y2 – y1)²).
     */

    private static Coordinate ZERO_COORD = new Coordinate(0, 0);


    private static double calculateDistanceBetweenCoordinates(Coordinate coord1, Coordinate coord2){
        return Math.sqrt(Math.pow(coord1.getxCoord() - coord2.getxCoord(), 2) +
                         Math.pow(coord1.getyCoord() - coord2.getyCoord(), 2));
    }

    public static Map<Coordinate, Double> calculateDistancesfromZero(List<Coordinate> coordinates){
        return coordinates.stream()
                .collect(Collectors.toMap(Function.identity(), coordinate -> PointDistanceCalculator.calculateDistanceBetweenCoordinates(ZERO_COORD, coordinate)));

    }
}
