package ParkingLot.VehicleFactory;

import ParkingLot.VehicleType;

public class Bike extends Vehicle{
    public Bike(String vehiclePlate) {
        super(vehiclePlate, VehicleType.BIKE);
    }
}
