package BookMyShow.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userId;
    private final String userName;
    private final String email;
    private final String password;
    private final String phone;
    private final List<String> bookingHistory;
    private final List<String> notification;
    private Double wallet;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Double getWalletAmount(){ return  wallet;}

    public void addWalletAmount(Double amount){
        wallet  = wallet + amount;
    }

    public List<String> getBookingHistory() {
        return bookingHistory;
    }

    public List<String> getNotification() {
        return notification;
    }

    public void addNotification(String message){
        notification.add(message);
    }
    public void addBookingHistory(String message){
        bookingHistory.add(message);
    }

    public User(String userId, String userName, String email, String password, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.wallet = 0.0;
        this.bookingHistory = new ArrayList<>();
        this.notification = new ArrayList<>();
    }
}
