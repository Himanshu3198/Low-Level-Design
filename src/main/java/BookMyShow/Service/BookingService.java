package BookMyShow.Service;

import BookMyShow.ENUM.Status;
import BookMyShow.Interface.PaymentStrategy;
import BookMyShow.Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BookingService {
    List<Booking> bookingList = new ArrayList<>();
    private static PaymentService paymentService;
    private static NotificationService notificationService;
    private static BookingHistoryService bookingHistoryService;

    public BookingService(){
        paymentService = new PaymentService();
        notificationService = new NotificationService();
        bookingHistoryService = new BookingHistoryService();

    }

    public Booking findBookingById(String bookingId){
        for(Booking record:bookingList){
            if(record.getBookingId().equals(bookingId)) return  record;
        }
        return  null;
    }

    public void placeBooking(Theater theater, Show show, User user, Double amount, String seatNumber, PaymentStrategy paymentStrategy){

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
            String message = "Movie ticket has been booking bookingId: "+bookingId+" Movie Name: "+show.getMovie().getTitle()+"Theater: "+theater.getName();
            notificationService.sendNotification(user,message);
            bookingHistoryService.addHistory(user,"BookingId: "+ bookingId+","+"Amount: "+amount+","+"Date: "+ new Date());
        }
        bookingList.add(new Booking(bookingId,seatNumber,show,user,amount));
    }

    public void cancelBooking(String bookingId){
        Booking booking = findBookingById(bookingId);
        String seatNumber = booking.getSeatNumber();
        Seats seat = booking.getShow().getSeat(seatNumber);
        if(seat.getStatus().equals(Status.BOOKED)){
            seat.setStatus(Status.AVAILABLE);;
        }
        System.out.println("Booking has been cancelled and Refund will be shortly process, Thank you");
        bookingList.remove(booking);
    }
}
