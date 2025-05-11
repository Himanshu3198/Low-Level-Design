package ParkingLot.VehicleFactory;

import ParkingLot.VehicleType;

public class Bus extends Vehicle{

    public Bus(String vehiclePlate){
        super(vehiclePlate, VehicleType.BUS);
    }
}
