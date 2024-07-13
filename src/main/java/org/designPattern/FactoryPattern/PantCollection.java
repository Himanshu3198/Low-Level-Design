package org.designPattern.FactoryPattern;

public class PantCollection  implements Garments{

    private ClothSize clothSize;
    private ClothColor clothColor;
    double price;
    private final String type = "PANT";
    public PantCollection(ClothSize clothSize, ClothColor clothColor, double price){
        this.clothSize=clothSize;
        this.clothColor=clothColor;
        this.price=price;
    }


    @Override
    public ClothSize getSize() {
        return clothSize;
    }

    @Override
    public ClothColor getColor() {
        return clothColor;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pant{" +
                "size=" + clothSize +
                ", color=" + clothColor +
                ", price=" + price +
                '}';
    }

    @Override
    public void garmentDescription() {
        System.out.println("=== below is the specification of this T-shirt===");
        System.out.println("color: "+clothColor);
        System.out.println("size: "+clothSize);
        System.out.println("price:"+price);
    }
}
