package SplitWise.Service.impl;

import SplitWise.Model.User;
import SplitWise.Service.SplitStrategy;

import java.util.List;
import java.util.Map;

public class ExactSplitStrategy implements SplitStrategy {
    @Override
    public Map<User, Double> split(Double totalAmount, List<User> participant, List<Double> values) {
        return Map.of();
    }
}
