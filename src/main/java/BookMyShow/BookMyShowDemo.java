package BookMyShow;

import BookMyShow.Interface.PaymentStrategy;
import BookMyShow.Interface.UpiPaymentImp;
import BookMyShow.Model.Movies;
import BookMyShow.Model.Theater;
import BookMyShow.Service.BookMyShowFacade;
import BookMyShow.Model.User;
import BookMyShow.Model.Show;

import java.util.UUID;

public class BookMyShowDemo {

    public static void main(String[] args) {

        BookMyShowFacade facade = new BookMyShowFacade();
        User user1 = new User("1","himansh","hs@gmsi.com","sfsfsf","9282828");
        User user2 = new User("2","ramesh","rms@gmail,com","sfsfss","9823424");

        Movies movie1 = new Movies(UUID.randomUUID().toString(),"YJHD","Fictional","rk,dp");
        Movies movie2 = new Movies(UUID.randomUUID().toString(),"BRDR","Fictional","sunny");

        Show show1 = new Show(UUID.randomUUID().toString(),movie1,"2025-02-19 12:15:PM",4);
        Show show2 = new Show(UUID.randomUUID().toString(),movie2,"2025-04-19 02:15:PM",5);

        Theater theater1 = new Theater(UUID.randomUUID().toString(),"IMAX");
        theater1.addShow(show1);
        theater1.addShow(show2);

        facade.showAllTheater();
        show1.displayAllSeats();
        PaymentStrategy upiPayment = new UpiPaymentImp();
        facade.bookTickets(theater1,show1,user1,300.0,"S3",upiPayment);
        show1.displayAllSeats();
        facade.showBookingHistory(user1);
        facade.showNotification(user1);
        facade.cancelBooking("0c012984-7586-4269-8250-3b22956d8814");
        show1.displayAllSeats();
        facade.showBookingHistory(user1);
        facade.showNotification(user1);





    }
}
