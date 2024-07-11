package org.designPattern.observerPattern;

public class Main {
    public static void main(String[] args) {
     MessageService messageService = new MessageService();
     Observer user1 = new User("raman");
     Observer user2 = new User("chaman");
     Observer user3 = new User("naman");
     messageService.subscribe(user1);
     messageService.subscribe(user2);
     messageService.subscribe(user3);
     messageService.notifyObserver("welcome to our entertainment service");
     messageService.unsubscribe(user2);
     messageService.notifyObserver("good bye to chaman");
    }
}