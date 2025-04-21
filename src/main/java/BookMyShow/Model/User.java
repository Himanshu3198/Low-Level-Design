package BookMyShow.Model;

import java.util.List;

public class User {
    private final String userId;
    private final String userName;
    private final String email;
    private final String password;
    private final String phone;
    private final List<String> bookingHistory;
    private final List<String> notification;

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

    public List<String> getBookingHistory() {
        return bookingHistory;
    }

    public List<String> getNotification() {
        return notification;
    }

    public User(String userId, String userName, String email, String password, String phone, List<String> bookingHistory, List<String> notification) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.bookingHistory = bookingHistory;
        this.notification = notification;
    }
}
