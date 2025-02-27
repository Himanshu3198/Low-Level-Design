package coffeeVendingMachine;

import java.util.Map;

public class Espresso implements Coffee{

    @Override
    public String getName() {
        return "Espresso";
    }

    @Override
    public int getPrice() {
        return 70;
    }

    @Override
    public Map<String, Integer> getRecipe() {
        return Map.of("Coffee beans",60,"Sugar",20,"Milk",60);
    }
}
