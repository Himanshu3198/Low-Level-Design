package org.designPattern.FactoryPattern;

public class Main {
    public static void main(String[] args) {
        GarmentsFactory garmentsFactory = new GarmentsFactory();
        Garments shirt1 = garmentsFactory.getGarment("SHIRT",ClothSize.MEDIUM,ClothColor.BLACK,40.58);
        Garments shirt2 = garmentsFactory.getGarment("SHIRT",ClothSize.LARGE,ClothColor.RED,100.24);
        Garments pant1 = garmentsFactory.getGarment("PANT",ClothSize.XL,ClothColor.BLUE,50.21);
        Garments pant2 = garmentsFactory.getGarment("PANT",ClothSize.XXL,ClothColor.GREEN,200.99);
        shirt1.showCollection();
        shirt2.showCollection();
        pant1.showCollection();
        pant2.showCollection();
    }
}
