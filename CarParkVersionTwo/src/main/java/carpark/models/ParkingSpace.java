package carpark.models;

import java.util.Optional;

public class ParkingSpace {

    private final int parkingSpaceNumber;
    private Vehicle occupyingVehicle;
    private ParkingStatus parkingStatus;

    public ParkingSpace(final int parkingSpaceNumber){
        this.parkingSpaceNumber = parkingSpaceNumber;
        this.parkingStatus = ParkingStatus.AVAILABLE;
    }
    
    public boolean containsVehicle(Vehicle vehicle){
//        return Optional.ofNullable(this.occupyingVehicle).stream()
//                .anyMatch(vehicle1 -> vehicle1.equals(vehicle));

        return vehicle.equals(occupyingVehicle);
    }

    public Optional<Integer> allocateParkingSpace(Vehicle vehicle){
        if(parkingStatus == ParkingStatus.AVAILABLE){
            occupyingVehicle = vehicle;
            parkingStatus = ParkingStatus.OCCUPIED;
            return Optional.of(parkingSpaceNumber);
        }else{
            return Optional.empty();
        }
    }

    public boolean isAvailable(){
        return parkingStatus.equals(ParkingStatus.AVAILABLE);
    }

    public void deAllocateVehicle() {
        Optional.ofNullable(occupyingVehicle).ifPresent(vehicle -> {
            this.parkingStatus = ParkingStatus.AVAILABLE;
            this.occupyingVehicle = null;
        });
    }
}