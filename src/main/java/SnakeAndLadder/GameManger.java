package SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class GameManger {

    private  Board board;
    private List<Snake> snakes ;
    private List<Ladder> ladders ;

    public GameManger(Board board){
        this.board = board;
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
    }




}
