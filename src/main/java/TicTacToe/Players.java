package TicTacToe;

public class Players {
    String name;
    Symbol symbol;
   public Players(String name, Symbol symbol){
        this.name = name;
        this.symbol = symbol;
    }
    public  String getName(){
        return this.name;
    }
    public Symbol getSymbol(){
        return  this.symbol;
    }
}
