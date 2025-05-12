package ParkingLot;

import ParkingLot.VehicleFactory.Bike;
import ParkingLot.VehicleFactory.Bus;
import ParkingLot.VehicleFactory.Car;
import ParkingLot.VehicleFactory.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotDemo {
    public static void main(String[] args) {
        try {
            ParkingLot lot = ParkingLot.getInstance();

            List<ParkingSpot> level1Spots = new ArrayList<>();

            for(int i=0;i<4;i++) level1Spots.add(new ParkingSpot(i,VehicleType.BIKE));
            for(int i=4;i<8;i++) level1Spots.add(new ParkingSpot(i,VehicleType.BUS));
            for(int i=8;i<12;i++) level1Spots.add(new ParkingSpot(i,VehicleType.CAR));

            lot.addLevel(1,new Level(1,level1Spots));

            Vehicle car1 = new Car("CAR123");
            Vehicle bus1 = new Bus("BUS342");
            Vehicle bike1 = new Bike("BIKE122");

            lot.displayAvailability();
            lot.parkedVehicle(car1);
            lot.parkedVehicle(bus1);
            lot.parkedVehicle(bike1);
            lot.displayAvailability();
            lot.unparkedVehicle("CAR123");
            lot.unparkedVehicle("BUS342");
            lot.displayAvailability();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
