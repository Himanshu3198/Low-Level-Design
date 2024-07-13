package org.designPattern.FactoryPattern;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
public class ConfigFactory {

   public  List<Garments> configGarments() throws FileNotFoundException{
        GarmentsFactory garmentsFactory = new GarmentsFactory();
        List<Garments> garments = new ArrayList<>();
        Gson gson = new Gson();
        Type garmentListType = new TypeToken<List<GarmentsModel>>() {}.getType();
        try(FileReader reader = new FileReader(Constant.GARMENTS_DATA_FILE_PATH)) {
            List<GarmentsModel>garmentData = gson.fromJson(reader, garmentListType);
            for(GarmentsModel garmentItr:garmentData){
//                System.out.println(garmentItr.toString());
                try{
                    ClothSize size = ClothSize.valueOf(garmentItr.getClothSize());
                    ClothColor color = ClothColor.valueOf(garmentItr.getClothColor());
                    Garments createGarment= garmentsFactory.getGarment(garmentItr.getType(),size,color,garmentItr.getPrice());
                    garments.add(createGarment);
                }catch (IllegalArgumentException e){
                    System.out.println("Invalid size or color in Json data");
                    e.printStackTrace();
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return  garments;
    }





}
