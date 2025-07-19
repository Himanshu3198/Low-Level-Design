package SnakeAndLadder;

import TicTacToe.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeLadderDemo {

    public static void main(String[] args) {
        System.out.println("====Welcome to Snake Ladder Game====");

        System.out.println("Enter No of players");
        Scanner sc = new Scanner(System.in);
        int noOfPlayers = sc.nextInt();
        List<Player>  players = new ArrayList<>();
        System.out.println("====Please enter Players name to play!====");
        for(int i=1;i<=noOfPlayers;i++){
            String name = sc.nextLine();
            Player player = new Player()
                    .setName(name)
                    .setId(i)
                    .setPos(0);
            players.add(player);
        }

        GameManger game = new GameManger(players);
        game.startGame();
    }
}
