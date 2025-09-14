package ElevatorDesign;

import java.util.*;


class State{

    int dist;
    Request request;

    public State(int dist, Request request) {
        this.dist = dist;
        this.request = request;
    }
}

public class ElevatorManager {

      private final FloorFactory floorFactory;
      private final static int WINDOW = 4;
      private int currentFloor;
      private int totalFloor;
      private Deque<Request> requestQueue;
      private PriorityQueue<State> upRequest;
      private PriorityQueue<State> downRequest;
      private HashMap<Integer,Request> dropFloor;



      public ElevatorManager(FloorFactory floorFactory, int currentFloor, int totalFloor){
          this.floorFactory = floorFactory;
          this.currentFloor = currentFloor;
          this.totalFloor = totalFloor;
          this.requestQueue = new ArrayDeque<>();
          this.upRequest = new PriorityQueue<>();
          this.downRequest =  new PriorityQueue<>();
          this.dropFloor = new HashMap<>();
          this.initializeDirectionRequest();

      }


      public void addRequest(Request request){
          requestQueue.addLast(request);
      }

      private void initializeDirectionRequest(){

          /* upward request */
          for(var request:requestQueue){
                int pickupFloor = floorFactory.getFloor(request.pickup());
                if(pickupFloor>= currentFloor){
                    upRequest.add(new State((pickupFloor-currentFloor),request));
                }else{
                    downRequest.add(new State((currentFloor-pickupFloor),request));
                }
          }

      }







}
