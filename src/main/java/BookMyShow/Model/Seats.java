package BookMyShow.Model;

import BookMyShow.ENUM.Status;

public class Seats {
    private final String seatNumber;
    private Status status;

    public Seats(String seatNumber, Status status) {
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }

}
