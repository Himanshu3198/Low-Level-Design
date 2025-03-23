package JavaNotes.MultiThreading;

class Table{

    synchronized void printTable(int n){
        for(int i=1;i<=n;i++){
            System.out.println(n*i);
        }
    }
}

class MyThread1 extends Thread{
    Table t;
    MyThread1(Table t){
       this.t = t;
    }
    public  void  run(){
        t.printTable(5);
    }
}
public class SynchronizedDemo {

    public static void main(String[] args) {

         Table t = new Table();
         MyThread1 t1 = new MyThread1(t);
         MyThread1 t2 = new MyThread1(t);
         t1.start();
         t2.start();

    }
}
