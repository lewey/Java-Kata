package carpark.models;

import java.util.Optional;

public class ParkingSpace {
    private Vehicle occupyingVehicle;
    private ParkingStatus parkingStatus;

    public ParkingSpace(){
        this.parkingStatus = ParkingStatus.AVAILABLE;
    }
    
    public boolean containsVehicle(Vehicle vehicle){
        return Optional.ofNullable(this.occupyingVehicle).stream()
                .anyMatch(vehicle1 -> vehicle1.equals(vehicle));
    }

    public void allocateParkingSpace(Vehicle vehicle){
        this.occupyingVehicle = vehicle;
        this.parkingStatus = ParkingStatus.OCCUPIED;
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