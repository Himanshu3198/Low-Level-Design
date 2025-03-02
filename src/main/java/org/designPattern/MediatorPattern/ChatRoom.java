package org.designPattern.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator{
    protected List<User> userList = new ArrayList<>();



    @Override
    public void sendMessage(String message,User sender) {
         for(User entry:userList){
             if(entry == sender) continue;
             entry.receiveMessage(message,sender);
         }
    }

    @Override
    public void addUser(User user) {
           userList.add(user);
    }
}
