package ElevatorDesign;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ElevatorManager {

      private Deque<Request> requestQueue = new LinkedList<>();

      public ElevatorManager(){}


      public void addRequest(Request request){
          requestQueue.addLast(request);
      }

      private void processRequest(){

      }

      private void findNearestFloor(){
          PriorityQueue<Integer,Request> minDist = new PriorityQueue<>();
      }



}
