package ParkingLot;

import java.util.List;

public class Level {

    private final int levelNumber;
    private final List<ParkingSpot> spotList;

    public Level(int levelNumber, List<ParkingSpot>spots){
        this.levelNumber = levelNumber;
        this.spotList = spots;
    }

    public int getLevelNumber() {return levelNumber;}

    public List<ParkingSpot> getSpotList() {return  spotList;}
}
