package org.designPattern.FactoryPattern;

public class GarmentsModel {
    String clothSize;
    String clothColor;
    double price;
    String type;

    public  String getClothSize(){
        return  clothSize;
    }
    public  String getClothColor(){
        return  clothColor;
    }
    public double getPrice(){
        return price;
    }
    public String getType(){
        return type;
    }

    @Override
    public String toString() {
        return "GarmentsModel{" +
                "type='" + type + '\'' +
                ", clothSize='" + clothSize + '\'' +
                ", clothColor='" + clothColor + '\'' +
                ", price=" + price +
                '}';
    }
}
