package org.designPattern.FactoryPattern;

public class PantCollection  implements Garments{

    private ClothSize clothSize;
    private ClothColor clothColor;
    double price;
    public PantCollection(ClothSize clothSize, ClothColor clothColor, double price){
        this.clothSize=clothSize;
        this.clothColor=clothColor;
        this.price=price;
    }
    @Override
    public void showCollection() {
        System.out.println("===Below is the specification of this pant===");
        System.out.println("color: "+clothColor);
        System.out.println("size: "+clothSize);
        System.out.println("price:"+price);
    }
}
