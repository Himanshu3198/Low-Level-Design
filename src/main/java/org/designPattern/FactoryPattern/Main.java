package org.designPattern.FactoryPattern;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
//    GarmentsService garmentsService;
    public static void main(String[] args) throws FileNotFoundException {

          GarmentsService garmentsService = new GarmentsService();
//          garmentsService.showAllGarments();
//        garmentsService.showAllGarments();
        garmentsService.showPants();

//        GarmentsFactory garmentsFactory = new GarmentsFactory();
//        ConfigFactory configFactory = new ConfigFactory();

//        for (Garments garment : g) {
//            // Example of using methods from Garments interface
//            System.out.println("Type: " + garment.getType());
//            System.out.println("Size: " + garment.getSize());
//            System.out.println("Color: " + garment.getColor());
//            System.out.println("Price: " + garment.getPrice());
//            System.out.println("\n");
//        }
    }
}
