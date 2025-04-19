package SplitWise;

import SplitWise.Model.Expense;
import SplitWise.Model.Group;
import SplitWise.Model.User;
import SplitWise.Service.SplitWiseService;
import SplitWise.Service.impl.EqualSplitStrategey;

import java.util.Arrays;
import java.util.List;

public class SplitWiseDemo {
    public static void main(String[] args) {
        SplitWiseService service = SplitWiseService.getInstance();
        User u1 = new User("U1","himanshu","hms@gmail","024");
        User u2 = new User("U2","divyanshu","nms@gmail","025");
        User u3 = new User("U3","sudanshu","gms@gmail","026");

        service.addUser(u1);
        service.addUser(u2);
        service.addUser(u3);
        Group g1 = new Group("G1","Trip to Goa");
        g1.addMember(u1);
        g1.addMember(u2);
        g1.addMember(u3);
        service.createGroup(g1);

        List<User> participants = Arrays.asList(u1,u2,u3);
        List<Double> values = List.of(0.0);
        Expense e1 = new Expense(u1, "Hotel", 900.0,participants, new EqualSplitStrategey().split(900.0,participants,values),values);
        service.addExpense("G1",e1);

        service.showBalance("U2");
        service.showBalance("U3");
        service.showBalance("U1");

//        after settlement
        service.settleUp("U2","U1",300.0);
        service.showBalance("U2");
        service.showBalance("U3");
        service.showBalance("U1");
        service.showTransactions();
    }





}
