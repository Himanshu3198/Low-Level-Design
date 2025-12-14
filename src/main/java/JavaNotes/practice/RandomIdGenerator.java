package JavaNotes.practice;

import java.util.Random;
import java.util.UUID;

public class RandomIdGenerator {

    public static String generatePinViaRandom(){

        Random random = new Random();

        int pin = random.nextInt(10000);
        return String.valueOf(pin);

    }

    public static String generatePinViaUUID(){

        String pin = UUID.randomUUID().toString().substring(0,4);
        return pin;
    }
    public static void main(String[] args) {

        System.out.println("RandomPin: "+generatePinViaRandom());
        System.out.println("RandomPin: "+generatePinViaRandom());
        System.out.println("UUIDPIN: "+generatePinViaUUID());
        System.out.println("UUIDPIN: "+generatePinViaUUID());

    }
}
