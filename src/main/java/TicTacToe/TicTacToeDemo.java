package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeDemo {
    public static void main(String[] args) {

        List<Players> playerList = new ArrayList<>();
        playerList.add(new Players("Himanshu",Symbol.X));
        playerList.add(new Players("Dipanshu",Symbol.O));
        Game  game = new Game(3,3,playerList);
        game.startGame();

    }
}
