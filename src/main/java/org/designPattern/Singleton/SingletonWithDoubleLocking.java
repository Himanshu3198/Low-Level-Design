package org.designPattern.Singleton;

public class SingletonWithDoubleLocking {

    private static volatile  SingletonWithDoubleLocking instance;

    private  SingletonWithDoubleLocking(){}

    public static SingletonWithDoubleLocking getInstance(){

          if(instance == null){  // first check

              synchronized (SingletonDesign.class){
                  if(instance == null) {  // second check
                      instance = new SingletonWithDoubleLocking();
                  }
              }
          }
          return instance;
    }

    public void hello(){
        System.out.println("Hello from double locking singleton!");
    }
}
