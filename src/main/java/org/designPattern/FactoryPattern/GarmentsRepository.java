package org.designPattern.FactoryPattern;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GarmentsRepository {
//    ConfigFactory configFactory;
    ConfigFactory configFactory = new ConfigFactory();
    List<Garments> garmentsList = new ArrayList<>();

    public GarmentsRepository() throws FileNotFoundException {
        garmentsList = configFactory.configGarments();
    }

    public List<Garments> getAllGarments() {
        return garmentsList;
    }

    public List<Garments> getPants() {
        return filterByType("PANT");
    }

    public List<Garments> getShirts() {
        return filterByType("SHIRT");
    }

    public List<Garments> getTShirts() {
        return filterByType("T-SHIRT");
    }

    public List<Garments> getJeans() {
        return filterByType("JEANS");
    }

    private List<Garments> filterByType(String type) {
        return garmentsList.stream().filter(g -> g.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
    }

}
