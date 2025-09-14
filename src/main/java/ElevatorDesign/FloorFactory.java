package ElevatorDesign;

public class FloorFactory {

    public int getFloor(Floor floor) {
        switch (floor) {
            case GROUND -> {
                return 0;
            }
            case ONE -> {
                return 1;
            }
            case TWO -> {
                return 2;
            }
            case THREE -> {
                return 3;
            }
            case FOUR -> {
                return 4;
            }
            case FIVE -> {
                return 5;
            }
            default -> throw new InvalidFloorException("The elevator does not go to this floor");
        }
    }
}
