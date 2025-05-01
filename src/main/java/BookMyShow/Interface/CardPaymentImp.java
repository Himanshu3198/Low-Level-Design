package BookMyShow.Interface;

import BookMyShow.ENUM.PaymentType;
import BookMyShow.Model.User;

public class CardPaymentImp implements PaymentStrategy{
    @Override
    public boolean pay(String bookingId, Double amount, User user) {
        System.out.println("Card Payment Successful for booking: "+bookingId+" amount: "+amount+" by user: "+user.getUserName());
        return true;
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CARD;
    }
}
