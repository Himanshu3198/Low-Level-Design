package BookMyShow.Service;

import BookMyShow.ENUM.Status;
import BookMyShow.Interface.PaymentStrategy;
import BookMyShow.Model.*;

import java.util.*;

public class BookingService {
    private static BookingService instance;
    private final Map<String,Theater> theaters = new HashMap<>();
    private final Map<String,Booking> bookingList = new HashMap<>();


    public BookingService(){}

    public static synchronized
    BookingService getInstance(){
        if(instance == null){
            instance = new BookingService();
        }
        return instance;
    }

    public void addTheater(Theater theater){
        theaters.put(theater.getTheaterId(),theater);
    }

    public Theater getTheater(String theaterId){
        return theaters.get(theaterId);
    }

    public List<Theater> getAllTheater(){
        return new ArrayList<>(theaters.values());
    }
    public synchronized void placeBooking(Theater theater, Show show, User user, Double amount, String seatNumber, PaymentStrategy paymentStrategy,PaymentService paymentService, NotificationService notificationService, BookingHistoryService bookingHistoryService){

        Seats seat = show.getSeat(seatNumber);
        Status status = seat.getStatus();

        if(status == Status.BOOKED){
            System.out.println("Booking cannot be placed! please try for other available seats");
            return;
        }
        String bookingId = UUID.randomUUID().toString();
        boolean isPaymentComplete = paymentService.processPayment(bookingId,amount,user,paymentStrategy);
        if(isPaymentComplete){
            seat.setStatus(Status.BOOKED);
            String message = "Movie ticket has been booked bookingId: "+bookingId+" Movie Name: "+show.getMovie().getTitle()+"Theater: "+theater.getName();
            notificationService.sendNotification(user,message);
            bookingHistoryService.addHistory(user,"BookingId: "+ bookingId+","+"Amount: "+amount+","+"Date: "+ new Date());
        }
        bookingList.put(bookingId,new Booking(bookingId,seatNumber,show,user,amount));
    }

    public synchronized void  cancelBooking(String bookingId, NotificationService notificationService, BookingHistoryService bookingHistoryService){
        Booking booking = bookingList.get(bookingId);
        String seatNumber = booking.getSeatNumber();
        Seats seat = booking.getShow().getSeat(seatNumber);
        if(seat.getStatus().equals(Status.BOOKED)){
            seat.setStatus(Status.AVAILABLE);
        }
//        adding refund in user wallet
        User user = booking.getUser();
        user.addWalletAmount(booking.getAmount());

        notificationService.sendNotification(booking.getUser(),"Booking has been cancelled for "+bookingId + " Refund will be shortly process, Thank you");
        System.out.println("Booking has been cancelled and Refund will be shortly process, Thank you");
        bookingList.remove(booking.getBookingId());

    }
}
