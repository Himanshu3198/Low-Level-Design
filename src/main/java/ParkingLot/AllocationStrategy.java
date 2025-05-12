package ParkingLot;

import ParkingLot.VehicleFactory.Vehicle;

import java.util.List;

public interface AllocationStrategy {
     ParkingSpot findSpot(List<ParkingSpot> parkingSpotList, Vehicle vehicle);
}
