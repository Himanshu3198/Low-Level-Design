package ElevatorDesign;

import ElevatorDesign.ElevatorManager;
import ElevatorDesign.Floor;
import ElevatorDesign.FloorFactory;
import ElevatorDesign.Request;

import java.util.List;

public class ElevatorDemo {
    public static void main(String[] args) {
        ElevatorManager elevatorManager = new ElevatorManager(new FloorFactory(), 3, 5);

        List<Request> requests = List.of(
                new Request(Floor.ONE, Floor.THREE),
                new Request(Floor.TWO, Floor.GROUND),
                new Request(Floor.FIVE, Floor.THREE),
                new Request(Floor.FOUR, Floor.TWO),
                new Request(Floor.THREE, Floor.GROUND)
        );

        requests.forEach(elevatorManager::addRequest);
        elevatorManager.start();
    }
}
