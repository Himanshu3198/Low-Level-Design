package BookMyShow.Model;

public class Booking {
    private  final String bookingId;
    private final String seatNumber;
    private final Show show;
    private final User user;
    private final Double amount;

    public String getBookingId() {
        return bookingId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public Show getShow() {
        return show;
    }

    public User getUser() {
        return user;
    }

    public Double getAmount() {
        return amount;
    }

    public Booking(String bookingId, String seatNumber, Show show, User user, Double amount) {
        this.bookingId = bookingId;
        this.seatNumber = seatNumber;
        this.show = show;
        this.user = user;
        this.amount = amount;
    }
}
