package JavaNotes.practice;

public class Practice1 {


    public static class GetMultiple extends Thread{

        public void run1(){
            for(int i=1;i<10;i++){
                System.out.println( Thread.currentThread().getName()+"Running output is:"+i*i);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        GetMultiple t1 = new GetMultiple();
        GetMultiple t2 = new GetMultiple();
        GetMultiple t3 = new GetMultiple();

        t1.start();
        t1.run1();
        t2.start();
        t2.run1();
        t3.start();
        t3.run1();
        t1.join();
        t2.join();
        t3.join();

    }
}
