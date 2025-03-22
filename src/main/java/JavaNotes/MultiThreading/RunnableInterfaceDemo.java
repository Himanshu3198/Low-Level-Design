package JavaNotes.MultiThreading;

class MyThread  implements  Runnable{
    public void  run(){

        for(int i=1;i<=5;i++){

            System.out.println("Current thread is: "+Thread.currentThread().getName()+","+i);
            try{
                Thread.sleep(500);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class RunnableInterfaceDemo {



    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        t1.start();
        try{
            t1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        t2.start();
    }
}
