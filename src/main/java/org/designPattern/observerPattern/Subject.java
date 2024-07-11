package org.designPattern.observerPattern;

public interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObserver(String message);
}
