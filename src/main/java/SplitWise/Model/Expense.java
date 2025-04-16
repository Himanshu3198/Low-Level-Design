package SplitWise.Model;

import java.util.List;
import java.util.Map;

public class Expense {
    private final String description;
    private final double amount;
    private final List<User> participants;
    private final Map<User, Double> splitMap;


    public Expense(String description, double amount, List<User> participants, Map<User, Double> splitMap){
        this.description = description;
        this.amount = amount;
        this.participants = participants;
        this.splitMap = splitMap;
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
}
