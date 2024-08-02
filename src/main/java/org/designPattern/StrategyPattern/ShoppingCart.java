package org.designPattern.StrategyPattern;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart{
    List<Item> items;
    public ShoppingCart(){
        this.items = new ArrayList<>();
    }

    public void add(Item item){
        items.add(item);
    }
    public void remove(Item item){
       this.items.remove(item);
    }
    public int calculateTotal(){
        int total = 0;
        for( Item itemItr : items ){
            total += itemItr.getPrice();
        }
        return total;
    }
    public void pay(PaymentStrategy strategy){
        int amount = calculateTotal();
        strategy.pay(amount);
    }


}
