package carpark;

import carpark.models.ParkingSpace;
import carpark.models.Vehicle;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/*
      This design uses an arraylist which itself does not utilise hashing.
 */

public class CarPark {

    private final ArrayList<ParkingSpace> spaces;
    private final double parkingCost = 2.00;
    private final AtomicInteger carParkCounter = new AtomicInteger(0);

    public CarPark(int numberOfSpaces){
        spaces = new ArrayList<>(numberOfSpaces);
        initSpaces(numberOfSpaces);
    }

    private void initSpaces(int numberOfSpaces){
        IntStream.rangeClosed(1, numberOfSpaces).
                forEach(x -> spaces.add(new ParkingSpace()));
    }

    public Optional<ParkingSpace> park(Vehicle vehicle) {
        final Optional<ParkingSpace> potentialParkingSpace = findFirstAvailableSpace();
        potentialParkingSpace.ifPresent(parkingSpace -> allocateParkingSpace(vehicle, parkingSpace));
        updateParkingCounter();

        return potentialParkingSpace;
    }

    private Optional<ParkingSpace> findFirstAvailableSpace(){
        return spaces.stream()
                .filter(ParkingSpace::isAvailable)
                .findFirst();
    }

    private void allocateParkingSpace(Vehicle vehicle, ParkingSpace parkingSpace){
        parkingSpace.allocateParkingSpace(vehicle);
    }

    public int numberOfAvailableSpaces(){
        final long freeSpaceCount = spaces.stream()
                .filter(ParkingSpace::isAvailable)
                .count();
        return (int) freeSpaceCount;
    }

    private void updateParkingCounter(){
        carParkCounter.incrementAndGet();
    }

    public void leave(Vehicle vehicle) {
        spaces.stream()
                .filter(parkingSpace -> parkingSpace.containsVehicle(vehicle))
                .forEach(ParkingSpace::deAllocateVehicle);
    }

    public int numberOfVisits() {
        return carParkCounter.get();
    }

    public double totalMoneyAccrued() {
        return carParkCounter.get() * parkingCost;
    }
}
