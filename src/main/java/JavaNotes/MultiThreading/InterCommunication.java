package JavaNotes.MultiThreading;

class SharedResource {
    int data;
    boolean available = false;

    synchronized void produce(int value) {
        while (available) {
            try {
                wait();
            } catch (Exception e) {
//                do nothing
            }
        }
        this.data = value;
        available = true;
        System.out.println("Produce: "+value);
        notify();
    }

    synchronized void consume() {
        while (!available) {
            try {
                wait();
            } catch (Exception e) {
//                do nothing
            }
        }
        System.out.println("Consumed: " + data);
        available = false;
        notify();
    }
}

public class InterCommunication {
    public static void main(String[] args) {
        SharedResource sr = new SharedResource();
        Thread produce = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                sr.produce(i);
            }
        });
        Thread consume = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                sr.consume();
            }
        });

        produce.start();
        consume.start();
    }
}
