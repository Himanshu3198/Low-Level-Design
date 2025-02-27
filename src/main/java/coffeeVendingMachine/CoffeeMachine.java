package coffeeVendingMachine;

public class CoffeeMachine {
    private final InventoryService inventoryService;
    private State currentState;
    private final PaymentService paymentService;

    CoffeeMachine(){
        this.inventoryService = new InventoryService();
        this.currentState = new ReadyState();
        this.paymentService = new PaymentService();
    }

    private static final class InstanceHolder {
        private static final CoffeeMachine instance = new CoffeeMachine();
    }

    public static CoffeeMachine getInstance(){
        return InstanceHolder.instance;
    }

    public void setState(State state){
        this.currentState = state;
    }
    public void displayMenu(){
        System.out.println("==== Cappuccino  Price 50Rs ====");
        System.out.println("==== Espresso Price 70Rs ====");
        System.out.println("==== Latte Price 80Rs ====");
    }

    public void dispenseCoffee(String type,int amount){

        Coffee coffee = CoffeeFactory.getCoffee(type);
        try{
            if(inventoryService.hasSufficientIngredient(coffee.getRecipe())){
                setState(new BrewingState());
                currentState.handleRequest();

                inventoryService.useIngredient(coffee.getRecipe());
                if(amount>= coffee.getPrice()){
                    paymentService.dispenseAmount(coffee,amount);
                    setState(new PaymentProcessing());
                    currentState.handleRequest();

                    System.out.println("Dispensing your coffee: "+coffee.getName());
                }else{
                    System.out.println("===Invalid Amount===");
                }

            }else{
                setState(new OutOfStock());
                currentState.handleRequest();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            setState(new OutOfServiceState());
            currentState.handleRequest();
        }

    }



}
