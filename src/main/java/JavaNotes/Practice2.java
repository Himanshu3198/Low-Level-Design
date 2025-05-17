package JavaNotes;

public class Practice2 {

    public static  class Factorial {
        private final int n;
        public Factorial(int n){
            this.n = n;
        }


        public synchronized int getFactorial(){
            int x=1;

            for(int i=this.n;i >=1;i--)  x = x*i;

            return x;
        }
    }

    public static  class FactThread implements Runnable{

        int t;
        public FactThread(int t){
            this.t = t;
        }

        @Override
        public void run(){
            Factorial f = new Factorial(t);
            int ans = f.getFactorial();
            System.out.println(Thread.currentThread().getName()+" answer is: "+ans);
        }
    }
    public static void main(String[] args) throws  InterruptedException{
        Thread t1 = new Thread(new FactThread(5));
        Thread t2 = new Thread(new FactThread(6));
        t1.start();
        t2.start();
        t1.join();
        t2.join();




    }
}
