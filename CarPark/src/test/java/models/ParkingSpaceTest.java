package models;

import carpark.models.ParkingSpace;
import carpark.models.Vehicle;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingSpaceTest {

    @Test
    public void testParkingSpaceCreationSetsTheStatusToAvailable(){
        final ParkingSpace parkingSpace = new ParkingSpace();
        assertTrue(parkingSpace.isAvailable());
    }

    @Test
    public void testAllocateParkingSpaceAllocatesAVehicle(){
        final ParkingSpace parkingSpace = new ParkingSpace();
        final Vehicle vehicle = new Vehicle("REG1");
        parkingSpace.allocateParkingSpace(vehicle);
        assertTrue(parkingSpace.containsVehicle(vehicle));
    }

    @Test
    public void testDeallocateCarParkingSpace(){
        final ParkingSpace parkingSpace = new ParkingSpace();
        final Vehicle vehicle = new Vehicle("REG1");
        parkingSpace.allocateParkingSpace(vehicle);
        parkingSpace.deAllocateVehicle();
        assertFalse(parkingSpace.containsVehicle(vehicle));
    }

    @Test
    public void testContainsVehicleReturnsTrueForAVehicleMatch(){
        final ParkingSpace parkingSpace = new ParkingSpace();
        final Vehicle vehicle = new Vehicle("REG1");
        parkingSpace.allocateParkingSpace(vehicle);
        assertTrue(parkingSpace.containsVehicle(vehicle));
    }

    @Test
    public void testContainsVehicleReturnsFalseForNoVehicleMatch(){
        final ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.allocateParkingSpace(new Vehicle("REG1"));
        assertFalse(parkingSpace.containsVehicle(new Vehicle("REG2")));
    }

    @Test
    public void testContainsVehicleReturnsFalseWhenThereIsNoVehiclePresent(){
        final ParkingSpace parkingSpace = new ParkingSpace();
        assertFalse(parkingSpace.containsVehicle(new Vehicle("REG2")));
    }

}
