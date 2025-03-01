package TicTacToe;

import java.util.List;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final List<Players> playersList;
    private int currentIndex;

     public Game(int size, int winCondition, List<Players> players){
         this.board =  Board.getInstance(size, winCondition);
         this.playersList = players;
         this.currentIndex = 0;
     }

     public void startGame() {
         boolean noWinner = true;
         Scanner scanner = new Scanner(System.in);
         while (noWinner) {
             board.displayBoard();
             Players currentPlayer = playersList.get(currentIndex);
             System.out.println("Play our move: "+currentPlayer.getName());
             int row = scanner.nextInt();
             int col = scanner.nextInt();

             if (!board.makeMove(row, col, currentPlayer.getSymbol())) {
                 System.out.println("Invalid move try again!");
                 continue;
             }
             if (board.isBoardFull()) {
                 board.displayBoard();
                 System.out.println("Game Tie!");
                 break;
             }
             if (board.checkWinner(currentPlayer.symbol)) {
                 noWinner = false;
                 board.displayBoard();
                 System.out.println("Winner is: " + currentPlayer.getName());
             }
             currentIndex = (currentIndex+1)%playersList.size();
         }
     }
}
