package ParkingLot;

import JavaNotes.MultiThreading.SynchronizedDemo;
import ParkingLot.VehicleFactory.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private static ParkingLot instance;
    private final Map<Integer,Level> levelMap = new HashMap<>();
    private final Map<String,ParkingSpot> occupiedMap = new ConcurrentHashMap<>();
    private final AllocationStrategy strategy  = new FindNearestSpotStrategy();

    public ParkingLot(){}

    public static synchronized ParkingLot getInstance(){
        if(instance == null){
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(int levelNumber, Level level){
        levelMap.put(levelNumber,level);
    }

    public synchronized boolean parkedVehicle(Vehicle vehicle){

        for(Level record: levelMap.values()){
            ParkingSpot spot = strategy.findSpot(record.getSpotList(),vehicle);
            if(spot != null && spot.assignedVehicle(vehicle)){
             occupiedMap.put(vehicle.getVehiclePlate(),spot);
                System.out.println("vehicle has been parked  with number_plate:"+vehicle.getVehiclePlate()+" at level: "+record.getLevelNumber()+" parking_spot: "+spot.getId());
                return true;
            }
        }
        System.out.println("Parking is not available at the moment!");
        return false;
    }

    public synchronized void unparkedVehicle(String vehicleId){

        ParkingSpot  spot = occupiedMap.get(vehicleId);
        if(spot == null){
            System.out.println("Vehicle is already not parked");
            return;
        }
        System.out.println("Vehicle has been released from spot_id: "+spot.getId()+" vehicle type: "+spot.getVehicleType()+" vehicleId: "+vehicleId);
        spot.releaseVehicle();
        occupiedMap.remove(vehicleId);

    }

    public synchronized void displayAvailability(){
        for(Level level: levelMap.values()){
            long available = level.getSpotList().stream().filter(ParkingSpot::isAvailable).count();
            System.out.println("level: "+level.getLevelNumber()+" Available spot count: "+available);
        }
    }



}
