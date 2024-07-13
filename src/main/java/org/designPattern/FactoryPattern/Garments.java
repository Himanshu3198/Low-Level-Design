package org.designPattern.FactoryPattern;

import java.util.ArrayList;
import java.util.List;

public interface Garments  {
    ClothSize getSize();
    ClothColor getColor();
    double getPrice();
    String getType();
    public void garmentDescription();
}
