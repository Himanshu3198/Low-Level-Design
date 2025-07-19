package SnakeAndLadder;


import java.util.List;
import java.util.Scanner;

public class GameManger {

    private final Board board;
    private final Dice dice;
    private final List<Player> players;
    private boolean isWinner;


    public GameManger(List<Player> players){
        this.board = new Board();
        this.dice = new Dice();
        this.players = players;
        isWinner = false;

    }

    public void startGame(){

        System.out.println("Game started...");
        int totalPlayers = players.size();
        int currentIdx=0;

        while(!isWinner){


            board.displayBoard();
            Player player = players.get(currentIdx);
            System.out.println("Player turn: "+player.getName());
            System.out.println("Press 1 to roll the dice!");
            Scanner sc = new Scanner(System.in);
            int command = sc.nextInt();

            if(command !=1){
                if(command == 0) {
                    System.out.println("=====Exit the Game!=====");
                    break;
                }
                System.out.println("Invalid key press please.Press 1 to make move!");
                continue;
            }
            int diceVal = dice.roll();
            int pos = board.getPositionAfterSnakeOrLadder(player.getPos()+ diceVal);
            isWinner = board.markPlayerPosition(pos,player);
            currentIdx = (currentIdx+1)%totalPlayers;
        }

    }















}
