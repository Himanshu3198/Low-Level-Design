package coffeeVendingMachine;

import java.util.Map;

public class Latte implements  Coffee{

    @Override
    public String getName() {
        return "Latte";
    }

    @Override
    public int getPrice() {
        return 80;
    }

    @Override
    public Map<String, Integer> getRecipe() {
        return Map.of("Coffee beans",80,"Sugar",70,"Milk",75);
    }
}
