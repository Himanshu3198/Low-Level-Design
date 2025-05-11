package ParkingLot.VehicleFactory;

import ParkingLot.VehicleType;

public abstract class Vehicle {
    private final String vehiclePlate;
    private final VehicleType vehicleType;

    public Vehicle(String vehiclePlate, VehicleType vehicleType) {
        this.vehiclePlate = vehiclePlate;
        this.vehicleType = vehicleType;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
