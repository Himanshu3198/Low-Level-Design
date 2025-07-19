package SnakeAndLadder;

import java.util.List;

public class Player {


    private int id;
    private String name;
    private int pos;
    private List<String> games;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public List<String> getGames(){
        return games;
    }

    public int getPos(){
        return pos;
    }
    public Player setPos(int pos){
        this.pos = this.pos;
        return this;
    }

    public Player setName(String name){
        this.name = name;
        return this;
    }

    public Player setId(int id){
        this.id = id;
        return this;
    }

    public Player addGame(String game){
        games.add(game);
        return this;
    }
}
