package BookMyShow.Model;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    private final String theaterId;
    private final String name;
    private List<Show> showsList;

    public Theater(String theaterId,String name){
        this.theaterId = theaterId;
        this.name = name;
        showsList = new ArrayList<>();
    }

    public void addShow(Show show){
        showsList.add(show);
    }

    public String getTheaterId() {
        return theaterId;
    }

    public String getName() {
        return name;
    }

    public List<Show> getShowsList() {
        return showsList;
    }

    public void getAllShows(){
        for(Show show:showsList){
            System.out.println(show.getShowId()+","+show.getShowTime()+","+show.getSeats());
        }
    }
}
