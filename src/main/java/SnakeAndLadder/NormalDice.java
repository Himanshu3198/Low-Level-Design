package SnakeAndLadder;


import java.util.concurrent.ThreadLocalRandom;

public class NormalDice implements DiceStrategy{

    public int roll(){
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}
