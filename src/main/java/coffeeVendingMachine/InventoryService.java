package coffeeVendingMachine;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    Map<String,Integer> stock = new HashMap<>();
    InventoryService(){
        this.stock.put("Coffee beans",200);
        this.stock.put("Sugar",200);
        this.stock.put("Milk",200);

    }

    public synchronized  boolean  hasSufficientIngredient(Map<String,Integer> recipe){
        for(Map.Entry<String,Integer> entry : recipe.entrySet()){
            if(stock.get(entry.getKey()) < entry.getValue()){
                System.out.println("Insufficient ingredient: "+entry.getKey());
                return  false;
            }
        }
        return true;
    }

    public synchronized void useIngredient(Map<String,Integer>recipe){
        for(Map.Entry<String,Integer> entry:recipe.entrySet()){
            stock.put(entry.getKey(), stock.get(entry.getKey()) - entry.getValue());
            if(stock.get(entry.getKey()) <50) {
                System.out.println(" ===Warning=== Insufficient Ingredient"+ entry.getKey());
            }
        }
    }
    public synchronized void refillStock(Map<String,Integer> refill){
        for(Map.Entry<String,Integer> entry:refill.entrySet()){
            stock.put(entry.getKey(),stock.get(entry.getKey())+ entry.getValue());
            System.out.println("Item has been refilled: "+ entry.getKey()+":"+stock.get(entry.getKey()));
        }
    }


}
