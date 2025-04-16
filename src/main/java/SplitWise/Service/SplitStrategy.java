package SplitWise.Service;
import  SplitWise.Model.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {

    public Map<User, Double> split(Double totalAmount, List<User> participant, List<Double> values);
}
