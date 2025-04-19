package SplitWise.Model;

import java.util.List;
import java.util.Map;

public class Expense {
    private final User paidBy;
    private final String description;
    private final double amount;
    private final List<User> participants;
    private final Map<User, Double> splitMap;
    private final List<Double> values;


    public Expense(User paidBy, String description, double amount, List<User> participants, Map<User, Double> splitMap, List<Double> values){
        this.paidBy = paidBy;
        this.description = description;
        this.amount = amount;
        this.participants = participants;
        this.splitMap = splitMap;
        this.values = values;
    }

    public double getAmount() {
        return amount;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public String getDescription() {
        return description;
    }

    public Map<User, Double> getSplitMap() {
        return splitMap;
    }

    public User getPaidBy() {
        return paidBy;
    }
    public List<Double> getValues(){
        return values;
    }
}
