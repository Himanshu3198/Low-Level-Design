package ParkingLot.VehicleFactory;

import ParkingLot.VehicleType;

public class Car extends Vehicle{
    public Car(String vehiclePlate) {
        super(vehiclePlate,VehicleType.CAR);
    }
}
