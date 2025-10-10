package org.designPattern.Singleton;

public class SingletonDesign {

    private static SingletonDesign instance;

    private SingletonDesign(){}

    public static SingletonDesign getInstance(){
        synchronized (SingletonDesign.class) {
            if (instance == null) {
                instance = new SingletonDesign();
            }
        }
        return instance;
    }

    public void hello(){
        System.out.println("hello from singleton");
    }


}
