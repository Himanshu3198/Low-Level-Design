package org.designPattern.StrategyPattern;

public class PaypalStrategy implements PaymentStrategy {

     private String emailId;
     private String password;

     public PaypalStrategy(String emailId, String password){
         this.emailId = emailId;
         this.password = password;
     }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
     public void pay(int amount){
        System.out.println(amount + " has been paid via Paypal");
    }
}
