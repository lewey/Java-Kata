package carpark.models;

import java.util.Objects;

public class Vehicle {
    private final String registrationNumber;

    public Vehicle(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(registrationNumber, vehicle.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}
