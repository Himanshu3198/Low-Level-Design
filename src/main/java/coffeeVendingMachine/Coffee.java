package coffeeVendingMachine;

import java.util.Map;

public interface Coffee {
    String getName();
    int getPrice();
    Map<String,Integer> getRecipe();
}
