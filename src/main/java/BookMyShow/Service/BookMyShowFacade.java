package BookMyShow.Service;

import BookMyShow.Interface.PaymentStrategy;
import BookMyShow.Model.Show;
import BookMyShow.Model.Theater;
import BookMyShow.Model.User;

import java.util.List;

public class BookMyShowFacade {
    private final BookingService bookingService;
    private final PaymentService paymentService;
    private final NotificationService notificationService;
    private final BookingHistoryService bookingHistoryService;

    public BookMyShowFacade() {
        this.bookingService = BookingService.getInstance();
        this.paymentService = new PaymentService();
        this.notificationService = new NotificationService();
        this.bookingHistoryService = new BookingHistoryService();
    }

    public void addTheater(Theater theater){
        bookingService.addTheater(theater);
    }

    public void showAllTheater(){
       List<Theater> theaterList = bookingService.getAllTheater();

       for(Theater record:theaterList){
           System.out.println(record.getTheaterId()+","+record.getName()+","+record.getShowsList());
       }
    }

    public void bookTickets(Theater theater, Show show, User user, Double amount, String seatNumber, PaymentStrategy paymentMethod){
        bookingService.placeBooking(theater,show,user,amount,seatNumber,paymentMethod,paymentService,notificationService,bookingHistoryService);
    }

    public void cancelBooking(String bookingId){
        bookingService.cancelBooking(bookingId,notificationService,bookingHistoryService);
    }

    public void showBookingHistory(User user){
        bookingHistoryService.showHistory(user);
    }

    public void showNotification(User user){
        notificationService.showNotification(user);
    }



}