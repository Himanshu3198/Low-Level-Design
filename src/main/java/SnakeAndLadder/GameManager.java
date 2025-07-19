package SnakeAndLadder;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    private final Board board;
    private final List<Player> players;
    private final DiceStrategy dice;
    private boolean isWinner;
    private final Scanner scanner;

    public GameManager(List<Player> players, DiceStrategy dice) {
        this.board = new Board();
        this.players = players;
        this.dice = dice;
        this.isWinner = false;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Game started...");
        int totalPlayers = players.size();
        int currentIdx = 0;

        while (!isWinner) {
            board.displayBoard();
            Player player = players.get(currentIdx);

            System.out.println("\nPlayer turn: " + player.getName());
            System.out.println("Press 1 to roll the dice, 0 to exit: ");
            int command = scanner.nextInt();

            if (command == 0) {
                System.out.println("===== Exiting the Game! =====");
                break;
            } else if (command != 1) {
                System.out.println("Invalid input. Please press 1 to roll.");
                continue;
            }

            int roll = dice.roll();
            System.out.println("You rolled: " + roll);

            int newPos = board.getPositionAfterSnakeOrLadder(player.getPos() + roll);
            try {
                isWinner = board.markPlayerPosition(newPos, player);
                System.out.println("Current position for " + player.getName() + ": " + player.getPos());
            } catch (InterruptedException e) {
                System.err.println("Interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
                break;
            } catch (InvalidPositionException e) {
                System.out.println(e.getMessage());
            }

            currentIdx = (currentIdx + 1) % totalPlayers;
        }

        scanner.close();
    }
}
