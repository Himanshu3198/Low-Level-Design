package TicTacToe;

import java.util.Arrays;

public class Board {
    private static  Board instance;
    int size;
    Symbol[][] board;
    int winCondition;

    public Board(int size, int winCondition){
        this.size = size;
        this.winCondition = winCondition;
        this.board = new Symbol[size][size];

        for(int i=0;i<size;i++){
            Arrays.fill(board[i],Symbol.EMPTY);
        }

    }

    public static Board getInstance(int size, int winCondition) { // Singleton design
        if(instance == null){
            instance = new Board(size, winCondition);
        }
        return  instance;
    }

    public  synchronized Boolean  makeMove(int row,int col, Symbol symbol){
        if(row>=0 && row<size && col>=0 && col<size){
            if(board[row][col] != Symbol.EMPTY) return false;
            board [row][col] = symbol;
            return  true;
        }else{
            System.out.println("Invalid Move try again!");
            return  false;
        }
    }

    public synchronized  void displayBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j]==Symbol.EMPTY?" _ ":board[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public boolean isBoardFull(){

        for(int i=0; i<size; i++){

            for(int j=0; j<size; j++){
                if(board[i][j] == Symbol.EMPTY) return false;
            }
        }
        return true;
    }

    public boolean checkWinner(Symbol symbol){
        return checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol) || checkAntiDiagonals(symbol);
    }

    public boolean checkRows(Symbol symbol){

        for(int i=0; i<size; i++){
            int count =0;
            for(int j=0; j<size; j++){
                count = (board[i][j] == symbol) ? count+1 : 0;
            }
            if(count == winCondition) return true;
        }
        return false;
    }
    public boolean checkColumns(Symbol symbol){
        for(int j=0; j<size; j++){
            int count =0;
            for(int i=0; i<size; i++){
                count = (board[i][j] == symbol) ? count+1 : 0;
            }
            if(count == winCondition) return true;
        }
        return false;
    }

    public  boolean checkDiagonals(Symbol symbol){

          for(int i=0; i<size; i++){
              for(int j=0; j<size; j++){
                  int count = 0,diagX = i, diagY = j;
                  while(diagX < size && diagY < size){

                      count = (board[diagX][diagY] == symbol) ? count+1 : 0;
                      diagX++;
                      diagY++;
                  }
                  if(count == winCondition) return true;

              }
          }
          return  false;
    }

    public boolean checkAntiDiagonals(Symbol symbol){

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                int count = 0, diagX = i, diagY = j;
                while(diagX<size && diagY>=0){
                    count = (board[diagX][diagY] == symbol) ? count+1 : 0;
                    diagX++;
                    diagY--;
                }
                if(count == winCondition) return true;
            }
        }
        return  false;
    }
}
