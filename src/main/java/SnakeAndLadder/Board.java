package SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int size = 100;
    private List<Snake> snakes ;
    private List<Ladder> ladders ;
    private int []board ;
    public Board(){
        board = new int[size];
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        initializeBoard();
    }



    private void initializeBoard(){
//        add snakes
        snakes.add(new Snake(98,8));
        snakes.add(new Snake(15,5));
        snakes.add(new Snake(85,60));
        snakes.add(new Snake(60,40));
        snakes.add(new Snake(40,14));
        snakes.add(new Snake(21,5));
//        add ladder
        ladders.add(new Ladder(20,2));
        ladders.add(new Ladder(42,10));
        ladders.add(new Ladder(96,6));
        ladders.add(new Ladder(20,3));
        ladders.add(new Ladder(88,34));
        ladders.add(new Ladder(72,32));
        ladders.add(new Ladder(56,24));
        ladders.add(new Ladder(47,16));
        ladders.add(new Ladder(33,13));

    }

    public int getPositionAfterSnakeOrLadder(int position){

        for(Ladder ladder:ladders){
            if(ladder.getBottom() == position){
                System.out.println("======Yay found ladder!=====");
                return ladder.getTop();
            }
        }
        for(Snake snake:snakes){
            if(snake.getHead() == position){
                System.out.println("======Oops Snake bite======");
                return snake.getTail();
            }
        }
        return position;
    }

    public void displayBoard(){

        System.out.println("========BOARD=======");
        for(int i=0;i<100;i++){
            if(i%10==0){
                System.out.println();
            }
            System.out.print(board[i]+" ");
        }
    }

    public boolean markPlayerPosition(int pos,Player player){

        if(pos>=0 && pos< size){
            board[pos] = player.getId();
            System.out.println("Player :"+player.getName()+" is at position: "+board[pos]);
            player.setPos(pos);
            return false;
        }else if(pos == size){
            player.setPos(pos);
            System.out.println("Player: "+player.getName()+"reach the: "+size);
            System.out.println("Player Win the game!"+player.getName());
            System.out.println("=====Game Over======");
            return true;
        }else{
            throw new InvalidPositionException("Invalid position"+pos);
        }
    }


}
