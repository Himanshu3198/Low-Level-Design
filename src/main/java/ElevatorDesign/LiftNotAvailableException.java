package ElevatorDesign;

public class LiftNotAvailableException extends RuntimeException {
    public LiftNotAvailableException(String message) {
        super(message);
    }
}
