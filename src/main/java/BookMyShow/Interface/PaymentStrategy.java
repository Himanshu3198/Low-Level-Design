package BookMyShow.Interface;
import BookMyShow.ENUM.PaymentType;
import BookMyShow.Model.User;
public interface PaymentStrategy {
    public boolean pay(String bookingId,Double amount,User user);
    public PaymentType getType();
}
