package com.kata.coordinates;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClosestCoordsToZeroTest {

    /*
           Coordinates - given a list of coordinates, write a function to find the first x amount of coordinates that are closest to coordinate (0,0).
           The formula to find the distance between the two points is usually given by d=√((x2 – x1)² + (y2 – y1)²).
     */

    @Test
    public void testFindClosestCoordinatesReturnsTwoCoordinates(){

        final List<Coordinate> coordinateList = List.of(
                new Coordinate(9, 3),
                new Coordinate(1,1),
                new Coordinate(2, 7),
                new Coordinate(2, 2),
                new Coordinate(0, 3));


        final List<Coordinate> result =  ClosestCoordsToZero.findClosestCoordinatesToZero(coordinateList, 2);

        List<Coordinate> expectedOutput = List.of(
                        new Coordinate(1,1),
                        new Coordinate(2, 2)

        );

        assertEquals(2, result.size());
        assertTrue(result.containsAll(expectedOutput));
    }

    @Test
    public void findThreeClosestCoordinates() {
        List<Coordinate> coords =
                List.of(
                        new Coordinate(9, 3),
                        new Coordinate(1,1),
                        new Coordinate(2, 7),
                        new Coordinate(2, 2),
                        new Coordinate(0, 3));

        List<Coordinate> expectedOutput =
                List.of(
                        new Coordinate(1,1),
                        new Coordinate(2, 2),
                        new Coordinate(0, 3)
                );

        final List<Coordinate> result =  ClosestCoordsToZero.findClosestCoordinatesToZero(coords, 3);

        assertEquals(3, result.size());
        assertTrue(result.containsAll(expectedOutput));
    }

    @Test
    public void findFourClosestCoordinates() {

        List<Coordinate> coords =
                List.of(
                        new Coordinate(9, 3),
                        new Coordinate(1,1),
                        new Coordinate(2, 7),
                        new Coordinate(2, 2),
                        new Coordinate(3,0),
                        new Coordinate(0, 3)
                );

        List<Coordinate> expectedOutput =
                List.of(
                        new Coordinate(1,1),
                        new Coordinate(2, 2),
                        new Coordinate(0, 3),
                        new Coordinate(3,0)
                );

        final List<Coordinate> result =  ClosestCoordsToZero.findClosestCoordinatesToZero(coords, 4);

        assertEquals(4, result.size());
        assertTrue(result.containsAll(expectedOutput));
    }

}
