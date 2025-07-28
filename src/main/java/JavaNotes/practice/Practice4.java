package JavaNotes.practice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practice4 {


    static class ReverseStrings{

        private final String operation;
        ReverseStrings(String s){
            this.operation = s;
        }

        public void getReverse(){
            String reverse = new StringBuilder(operation).reverse().toString();
            System.out.printf("Original %s | Reverse %s | Thread %s\n",operation,reverse,Thread.currentThread().getName());
        }

    }

    public static void main(String[] args) {
     List<String> list = Arrays.asList("Apple","Banana","Pomegranate","Orange","Strawberry","Blackberry","Guava","Avocardo");

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(String record:list){
            ReverseStrings task = new ReverseStrings(record);
            executorService.submit(task::getReverse);
        }
        executorService.shutdown();
    }
}
