package coffeeVendingMachine;

public class CoffeeFactory {
    public static Coffee getCoffee(String type){
        return switch (type.toLowerCase()) {
            case "cappuccino" -> new Cappuccino();
            case "espresso" -> new Espresso();
            case "latte" -> new Latte();
            default -> throw new IllegalArgumentException("Invalid Coffee type Selected");
        };

    }
}
