package SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int size = 100;
    private final Map<Integer, Integer> snakes = new HashMap<>();
    private final Map<Integer, Integer> ladders = new HashMap<>();
    private final int[] board = new int[size + 1];

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        snakes.put(98, 8);
        snakes.put(85, 60);
        snakes.put(60, 40);
        snakes.put(40, 14);

        ladders.put(2, 20);
        ladders.put(10, 42);
        ladders.put(6, 96);
        ladders.put(3, 20);
        ladders.put(34, 88);
        ladders.put(32, 72);
    }

    public int getPositionAfterSnakeOrLadder(int pos) {
        if (snakes.containsKey(pos)) {
            System.out.println("Oops! Bitten by snake at: " + pos);
            return snakes.get(pos);
        } else if (ladders.containsKey(pos)) {
            System.out.println("Yay! Climbed ladder at: " + pos);
            return ladders.get(pos);
        }
        return pos;
    }

    public void displayBoard() {
        System.out.println("\n======= BOARD =======");
        for (int i = 1; i <= size; i++) {
            System.out.print((board[i] != 0 ? board[i] : ".") + " ");
            if (i % 10 == 0) System.out.println();
        }
    }

    public boolean markPlayerPosition(int pos, Player player) throws InterruptedException {
        if (pos > size) {
            System.out.println("Roll exceeds board limit. Try again!");
            return false;
        } else if (pos == size) {
            player.setPos(pos);
            System.out.println("🎉 Player " + player.getName() + " wins! 🎉");
            Thread.sleep(3000);
            return true;
        } else if (pos < 0) {
            throw new InvalidPositionException("Invalid position: " + pos);
        } else {
            board[player.getPos()] = 0;
            if (board[pos] != 0) {
                System.out.println("⚠️ Multiple players at same position!");
            }
            board[pos] = player.getId();
            player.setPos(pos);
            return false;
        }
    }
}
