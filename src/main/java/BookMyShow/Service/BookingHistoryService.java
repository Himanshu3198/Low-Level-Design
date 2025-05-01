package BookMyShow.Service;
import BookMyShow.Model.User;

public class BookingHistoryService {
    public void addHistory(User user, String message){
        user.addBookingHistory(message);
        System.out.println("Booking History added for user: "+user.getUserName()+":"+message);
    }
    public void showHistory(User user){
        for(String record:user.getBookingHistory()){
            System.out.println(record);
        }
    }
}
