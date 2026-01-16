package carpark;

import carpark.models.Vehicle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarParkTest {

    /**
     * Design a vehicle car park, so that vehicles are allotted the first available free space.
     * There are charges for parking.
     * Determine the free available spaces to be allocated to the vehicles.
     * All parking spaces are the same size.
     *
     * You should be able to handle:
     * - A car trying to enter when there are no spaces
     * - If a vehicle leaves the car park (freeing up a space), you should be able to give that free space to an incoming vehicle.
     * - Print the total number of vehicles that used the car park at the end of day.
     * - Print total money collected at end of the day.
     *
     * Example 1 : All spaces free
     * 1 (free), 2 (free), 3 (free), 4 (free), 5 (free) -> park in 1.
     *
     * Example 2: One space free
     * 1 (occupied), 2 (occupied), 3 (occupied), 4 (occupied), 5 (free) -> park in 5.
     */


    @Test
    public void testNumberOfSpacesAvailableAfterCarParkCreation(){
        final CarPark carPark = new CarPark(2);
        assertEquals(2, carPark.numberOfAvailableSpaces());
    }

    @Test
    public void testParkCanParkASingleVehicle(){
        final CarPark carPark = new CarPark(1);
        final Vehicle vehicle = new Vehicle("REG1");
        final String parkingResult = carPark.park(vehicle);

        assertEquals(0, carPark.numberOfAvailableSpaces());
        assertEquals("Park in 1", parkingResult);
    }

    @Test
    public void testParkWillNotParkAVehicleWhenNoSpacesAreAvailable(){
        final CarPark carPark = new CarPark(1);
        carPark.park(new Vehicle("REG1"));
        final String parkingResult = carPark.park(new Vehicle("REG2"));

        assertEquals("No spaces available", parkingResult);
    }

    @Test
    public void testParkWillAllocateNextFreeSpace(){
        final CarPark carPark = new CarPark(2);
        carPark.park(new Vehicle("REG1"));

        Vehicle vehicle2 = new Vehicle("REG2");
        final String parkingResult = carPark.park(vehicle2);

        assertEquals(0, carPark.numberOfAvailableSpaces());
        assertEquals("Park in 2", parkingResult);

    }

    @Test
    public void testLeaveWillAllowAVehicleToLeaveAndFreeUpASpace(){
        final CarPark carPark = new CarPark(1);
        final Vehicle vehicle = new Vehicle("REG1");
        carPark.park(vehicle);
        carPark.leave(vehicle);

        assertEquals(1, carPark.numberOfAvailableSpaces());
    }

    @Test
    public void testTotalNumberOfVisits(){
        final CarPark carPark = new CarPark(1);
        final Vehicle vehicle = new Vehicle("REG1");
        carPark.park(vehicle);
        final int numberOfVisits = carPark.numberOfVisits();
        assertEquals(1, numberOfVisits);
    }

    @Test
    public void testTotalMoneyAccrued(){
        final CarPark carPark = new CarPark(1);
        final Vehicle vehicle = new Vehicle("REG1");
        carPark.park(vehicle);
        final double moneyAccrued = carPark.totalMoneyAccrued();
        assertEquals(2.00, moneyAccrued, 0);
    }
}
