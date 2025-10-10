package org.designPattern.Singleton;

public class UserA {


    public static void main(String[] args) {

        SingletonDesign s1 = SingletonDesign.getInstance();
        SingletonDesign s2 = SingletonDesign.getInstance();
        SingletonWithDoubleLocking s3 = SingletonWithDoubleLocking.getInstance();

        s1.hello();
        s2.hello();
        s3.hello();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        if(s1.hashCode() == s2.hashCode()){
            System.out.println("both pointing to same reference");
        }else{
            System.out.println("different instance exist");
        }
    }
}
