package com.kata.coordinates;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClosestCoordsToZero {
    public static List<Coordinate> findClosestCoordinatesToZero(List<Coordinate> coordinateList, int closestNoOfCoords) {

        final Map<Coordinate, Double> coordsWithDistances = PointDistanceCalculator.calculateDistancesfromZero(coordinateList);

        return coordsWithDistances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(closestNoOfCoords)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
