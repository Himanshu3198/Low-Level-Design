package org.designPattern.StrategyPattern;

public class CreditCardStrategy implements PaymentStrategy{

    private String cardNumber;
    private String cvv;
    private String validDate;

    public CreditCardStrategy(String cardNumber, String cvv, String validDate){
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.validDate = validDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }
    @Override
    public void pay(int amount){
        System.out.println(amount+" has been paid via Credit Card ");
    }
}
