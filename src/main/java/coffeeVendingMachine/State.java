package coffeeVendingMachine;

import com.google.gson.internal.bind.util.ISO8601Utils;

public interface State {
    void handleRequest();
}

class ReadyState implements  State{

    @Override
    public void handleRequest() {
        System.out.println("Machine is ready to serve your Coffee.");
    }
}

class BrewingState implements  State{
    @Override
    public void  handleRequest(){
        System.out.println("Brewing your coffee.");
    }
}

class OutOfServiceState implements State{
    @Override
    public void handleRequest(){
        System.out.println("Sorry machine is out of service ");
    }
}
class OutOfStock implements  State{

    @Override
    public void handleRequest() {
        System.out.println("Sorry Coffee is out of stocks!");
    }
}

class PaymentProcessing implements State{

    @Override
    public void handleRequest() {
        System.out.println("Collect your change. Thank You!");
    }
}
