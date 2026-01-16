package com.kata.coordinates;

import java.util.Objects;

public class Coordinate {

    private final int xCoord;
    private final int yCoord;

    public Coordinate(final int xCoordinate, final int yCoordinate){
        this.xCoord = xCoordinate;
        this.yCoord = yCoordinate;
    }

    public int getxCoord() { return xCoord;}
    public int getyCoord() { return yCoord;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return xCoord == that.xCoord && yCoord == that.yCoord;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }
}
