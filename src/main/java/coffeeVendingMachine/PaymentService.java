package coffeeVendingMachine;

public class PaymentService {

    public synchronized  void dispenseAmount(Coffee coffee,int amount){
        if(amount>coffee.getPrice()){
            int change = amount-coffee.getPrice();
            System.out.println("returning the change: "+change);
        }

    }
}
