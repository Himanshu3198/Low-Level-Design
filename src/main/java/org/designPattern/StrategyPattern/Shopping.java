package org.designPattern.StrategyPattern;

public class Shopping {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item(1,50);
        Item item2 = new Item(2,100);
        Item item3 = new Item(3,300);
        cart.add(item1);
        cart.add(item2);
        cart.add(item3);

        cart.pay(new CreditCardStrategy("1234ABDCD","234","12242027"));
        cart.remove(item1);
        cart.pay(new PaypalStrategy("himnashu@gmail.com","ohsirt@22"));

    }
}
