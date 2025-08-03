package ElevatorDesign;

public class InvalidFloorException extends RuntimeException {
    public InvalidFloorException(String message) {
        super(message);
    }
}
