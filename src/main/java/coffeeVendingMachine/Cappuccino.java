package coffeeVendingMachine;

import java.util.Map;

public class Cappuccino implements  Coffee{

    @Override
    public String getName() {
        return "Cappuccino";
    }

    @Override
    public int getPrice() {
        return 50;
    }

    @Override
    public Map<String,Integer> getRecipe(){
        return Map.of("Coffee beans",50,"Sugar",10,"Milk",50);
    }
}
