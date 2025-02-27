package coffeeVendingMachine;

public class CoffeeMachineDemo {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.displayMenu();
        coffeeMachine.dispenseCoffee("Cappuccino",100);
        coffeeMachine.dispenseCoffee("Latte",200);
        coffeeMachine.dispenseCoffee("Espresso",20);
    }
}
