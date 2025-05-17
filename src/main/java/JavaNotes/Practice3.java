package JavaNotes;

import java.util.ArrayList;
import java.util.List;

public class Practice3 {

     static  class Fibonacci{

        private  int n;
        private final List<Integer> list;

        public Fibonacci(int n){
            this.n = n;
            list= new ArrayList<>();
            list.add(0);
            list.add(1);
        }

        public synchronized  List<Integer> getSeries(){
            while(n-->0){
                int last = list.getLast();
                int scndLast = list.get(list.size()-2);
                list.add(last+scndLast);
            }
            return list;
        }
    }

    static  class MyThread implements  Runnable{
         private final Fibonacci fibonacci;

         MyThread(Fibonacci fibonacci){
             this.fibonacci = fibonacci;
         }
         @Override
        public void run(){
             for(int record: fibonacci.getSeries()){
                 System.out.print(Thread.currentThread().getName()+" record: "+record);
             }
             System.out.println();
         }
    }
    public static void main(String[] args) throws InterruptedException {
        Fibonacci f1 = new Fibonacci(5);
        Thread t1 = new Thread(new MyThread(f1));
        t1.start();
        t1.join();


    }
}
