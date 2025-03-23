package JavaNotes.MultiThreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class workerThread implements Runnable{
    String message;
    workerThread(String message){
        this.message = message;
    }
    public void run(){

        try{
            System.out.println("Thread->"+Thread.currentThread().getName()+", "+message);
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
//        System.out.println("Thread->"+Thread.currentThread().getName());
    }
}
public class ThreadPoolExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=1;i<=5;i++){
            Runnable worker = new workerThread("Task"+i);
            executor.execute(worker);
        }
        executor.shutdown();

    }


}
