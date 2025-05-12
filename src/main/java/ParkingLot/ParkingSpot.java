package ParkingLot;

import ParkingLot.VehicleFactory.Vehicle;

public class ParkingSpot {
    private final int id;
    private Vehicle currentVehicle;
    private final VehicleType vehicleType;

    public ParkingSpot(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.currentVehicle = null;
    }

    public int getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public synchronized boolean isAvailable(){
        return currentVehicle == null;
    }

    public synchronized boolean assignedVehicle(Vehicle vehicle){
        if(isAvailable() && vehicle.getVehicleType().equals(vehicleType)){
            this.currentVehicle = vehicle;
            return true;
        }
        return false;
    }
    public synchronized void releaseVehicle(){
//        System.out.println("Vehicle has been released:"+currentVehicle.getVehiclePlate());
        this.currentVehicle = null;
    }
}
