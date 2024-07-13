package org.designPattern.FactoryPattern;

import java.io.FileNotFoundException;
import java.util.List;

public class GarmentsService {

    //    GarmentsRepository garmentsRepository;
    GarmentsRepository garmentsRepository = new GarmentsRepository();

    public GarmentsService() throws FileNotFoundException {
    }

    public void showAllGarments() {
        List<Garments> garments = garmentsRepository.getAllGarments();
        for (Garments garmentsItr : garments) {
            System.out.println(garmentsItr.toString());
        }
    }

    public void showPants() {
        List<Garments> garments = garmentsRepository.getPants();
        for (Garments garmentsItr : garments) {
            System.out.println(garmentsItr.toString());
        }
    }

    public void showTShirts() {
        List<Garments> garments = garmentsRepository.getTShirts();
        for (Garments garmentsItr : garments) {
            System.out.println(garmentsItr.toString());
        }
    }

    public void showJeans() {
        List<Garments> garments = garmentsRepository.getJeans();
        for (Garments garmentsItr : garments) {
            System.out.println(garmentsItr.toString());
        }
    }

    public void showShirts() {
        List<Garments> garments = garmentsRepository.getShirts();
        for (Garments garmentsItr : garments) {
            System.out.println(garmentsItr.toString());
        }
    }

}
