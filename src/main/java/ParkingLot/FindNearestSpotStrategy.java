package ParkingLot;

import ParkingLot.VehicleFactory.Vehicle;

import java.util.List;

public class FindNearestSpotStrategy implements AllocationStrategy{
    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingSpotList, Vehicle vehicle) {
        return  parkingSpotList.stream()
                .filter(ParkingSpot::isAvailable)
                .filter(parkingSpot -> parkingSpot.getVehicleType() == vehicle.getVehicleType())
                .findFirst()
                .orElse(null);
    }
}
