package org.designPattern.FactoryPattern;

public class ShirtCollection implements Garments {
    private ClothSize clothSize;
    private ClothColor clothColor;
    double price;
    public ShirtCollection(ClothSize clothSize, ClothColor clothColor, double price){
        this.clothColor=clothColor;
        this.clothSize=clothSize;
        this.price=price;
    }

    @Override
    public void showCollection() {
        System.out.println("=== below is the specification of this shirt===");
        System.out.println("color: "+clothColor);
        System.out.println("size: "+clothSize);
        System.out.println("price:"+price);
    }
}
