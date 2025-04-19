package SplitWise.Service.impl;

import SplitWise.Model.User;
import SplitWise.Service.SplitStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExactSplitStrategy implements SplitStrategy {
    @Override
    public Map<User, Double> split(Double totalAmount, List<User> participant, List<Double> values) {
         Map<User, Double> splitMap = new HashMap<>();
         for(int i=0;i<participant.size();i++){
             splitMap.put(participant.get(i),values.get(i));
         }
         return splitMap;
    }
}
