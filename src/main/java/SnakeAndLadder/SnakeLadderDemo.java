package SnakeAndLadder;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeLadderDemo {

    public static void main(String[] args) {
        System.out.println("==== Welcome to Snake & Ladder Game ====");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int noOfPlayers = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= noOfPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String name = sc.nextLine();
            players.add(new Player().setId(i).setName(name).setPos(0));
        }

        GameManager gameManager = new GameManager(players, new NormalDice());
        gameManager.startGame();
    }
}
