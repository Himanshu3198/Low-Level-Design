package SplitWise.Service;

import SplitWise.Model.Expense;
import SplitWise.Model.Group;
import SplitWise.Model.Transaction;
import SplitWise.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitWiseService {

    private static SplitWiseService instance;
    private final Map<String,User> users = new HashMap<>();
    private final Map<String, Group> groups = new HashMap<>();
    private final Map<String, Map<String,Double>> balanceSheet = new HashMap<>();
    private final List<Transaction> transactionList = new ArrayList<>();

    private SplitWiseService(){}

    public static synchronized SplitWiseService getInstance(){
        if(instance == null){
            instance = new SplitWiseService();
        }
        return  instance;
    }

    public void addUser(User user){
        users.put(user.getUserId(),user);
        balanceSheet.put(user.getUserId(), new HashMap<>());
    }
    public void createGroup(Group group){
        groups.put(group.getGroupId(),group);
    }
    public void addExpense(String groupId, Expense expense){
        Group group = groups.get(groupId);
        group.addExpense(expense);
        updateBalances(expense);
    }
    private void updateBalances(Expense expense){
        User paidBy = expense.getPaidBy();
        Map<User,Double> splitMap = expense.getSplitMap();
        for(Map.Entry<User,Double> entry:expense.getSplitMap().entrySet()){
            User u = entry.getKey();
            if(u.getUserId().equals(paidBy.getUserId())) continue;
            Double amount =  splitMap.get(u);
            balanceSheet.get(paidBy.getUserId()).put(u.getUserId(),balanceSheet.get(paidBy.getUserId()).getOrDefault(u.getUserId(),0.0)-amount);
            balanceSheet.get(u.getUserId()).put(paidBy.getUserId(),balanceSheet.get(u.getUserId()).getOrDefault(paidBy.getUserId(),0.0)+amount);
        }

    }

    public void showBalance(String userId){
        Map<String,Double> balance = balanceSheet.get(userId);
        for(Map.Entry<String,Double>entry:balance.entrySet()){
            if(entry.getValue().equals(0.0)) continue;
            if(entry.getValue()<0)
            System.out.println(entry.getKey()+"ows: "+entry.getValue());
            else System.out.println("You ows: "+entry.getValue()+" "+entry.getKey());
        }
    }

    public void settleUp(String fromUser, String toUser, Double amount){
        balanceSheet.get(fromUser).put(toUser,balanceSheet.get(fromUser).getOrDefault(toUser,0.0)-amount);
        balanceSheet.get(toUser).put(fromUser,balanceSheet.get(toUser).getOrDefault(fromUser,0.0)+amount);
        transactionList.add(new Transaction(fromUser,toUser, amount));
    }
    public void showTransactions(){
        System.out.println("=====Transactions=====");
        for(Transaction t:transactionList){
            System.out.println("from: "+t.getFrom()+","+"to: "+t.getTo()+","+"Settled: "+t.getAmount());
        }
    }

}
