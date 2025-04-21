package BookMyShow.Model;

import java.util.Map;
import BookMyShow.ENUM.Status;

public class Show {
    private final String showId;
    private final Movies movie;
    private final String showTime;
    private Map<String,Seats> seats;

    public Show(String showId, Movies movie, String showTime, Map<String, Seats> seats,int seatCapacity) {
        this.showId = showId;
        this.movie = movie;
        this.showTime = showTime;
        for(int i=1;i<=seatCapacity;i++){
            String seatNumber = "S"+i;
            assert this.seats != null;
            this.seats.put(seatNumber,new Seats(seatNumber, Status.AVAILABLE));
        }
    }

    public String getShowId() {
        return showId;
    }

    public Movies getMovie() {
        return movie;
    }

    public String getShowTime() {
        return showTime;
    }

    public Map<String, Seats> getSeats() {
        return seats;
    }
    public Seats getSeat(String seatNumber){
        return seats.get(seatNumber);
    }
    public void displayAllSeats(){
        for(Seats seats1:seats.values()){
            System.out.println("Seat Number: "+seats1.getSeatNumber()+" Status: "+seats1.getStatus());
        }
    }
}
