package BookMyShow.Service;
import BookMyShow.Interface.PaymentStrategy;
import BookMyShow.Model.User;

public class PaymentService {

     boolean processPayment(String bookingId, Double amount, User user, PaymentStrategy strategy){
        if(strategy == null) throw new IllegalArgumentException("No payment strategy provided!");
        return  strategy.pay(bookingId,amount,user);

    }
}
