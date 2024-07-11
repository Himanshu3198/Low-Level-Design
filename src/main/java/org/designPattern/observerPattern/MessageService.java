package org.designPattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class MessageService implements  Subject{
    private  List<Observer> observers = new ArrayList<>();


    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
      observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
       for(Observer observer:observers){
             observer.update(message);
       }
    }
}
