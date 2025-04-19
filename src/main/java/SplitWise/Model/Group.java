package SplitWise.Model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final String  groupId;
    private  final String name;
    private final List<User> members;
    private final List<Expense> expenses;


    public Group(String groupId, String name){
        this.groupId = groupId;
        this.name = name;
        this.members = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }
    public void addMember(User user){
        members.add(user);
    }
    public void addExpense(Expense expense){
        expenses.add(expense);
    }
    public List<User> getMembers() {return members;}
    public List<Expense> getExpenses() {return expenses;}
    public String getGroupId() { return  groupId;}
}
