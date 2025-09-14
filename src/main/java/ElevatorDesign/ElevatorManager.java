package ElevatorDesign;

import java.util.*;

class State {
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
    private Directions currentDirection;
    private Deque<Request> requestQueue;
    private PriorityQueue<State> upRequest;
    private PriorityQueue<State> downRequest;
    private HashMap<Integer, List<Request>> dropFloor;

    public ElevatorManager(FloorFactory floorFactory, int currentFloor, int totalFloor) {
        this.floorFactory = floorFactory;
        this.currentFloor = currentFloor;
        this.totalFloor = totalFloor;
        this.currentDirection = Directions.UP; // start UP by default
        this.requestQueue = new ArrayDeque<>();
        this.upRequest = new PriorityQueue<>(Comparator.comparingInt(s -> s.dist));
        this.downRequest = new PriorityQueue<>(Comparator.comparingInt(s -> s.dist));
        this.dropFloor = new HashMap<>();
    }

    public void addRequest(Request request) {
        requestQueue.addLast(request);
    }

    public void start() {
        initializeDirectionRequest();
        serveRequest();
    }

    private void initializeDirectionRequest() {
        int limit = 0;
        while (!requestQueue.isEmpty() && limit <= WINDOW) {
            Request request = requestQueue.pollFirst();
            limit++;
            int pickupFloor = floorFactory.getFloor(request.pickup());

            if (pickupFloor >= currentFloor) {
                upRequest.add(new State(pickupFloor - currentFloor, request));
            } else {
                downRequest.add(new State(currentFloor - pickupFloor, request));
            }
        }
    }

    private void serveRequest() {
        while (!upRequest.isEmpty() || !downRequest.isEmpty() || !dropFloor.isEmpty()) {

            System.out.println("[Floor " + currentFloor + ", Direction " + currentDirection + "]");

            // Drop-offs
            if (dropFloor.containsKey(currentFloor)) {
                for (Request req : dropFloor.get(currentFloor)) {
                    System.out.println("  Drop at floor: " + req.drop());
                }
                dropFloor.remove(currentFloor);
            }

            // Pickups depending on direction
            if (currentDirection == Directions.UP && !upRequest.isEmpty() &&
                    currentFloor == floorFactory.getFloor(upRequest.peek().request.pickup())) {
                Request req = upRequest.poll().request;
                System.out.println("  Pickup at floor: " + req.pickup());
                dropFloor.computeIfAbsent(floorFactory.getFloor(req.drop()), k -> new ArrayList<>()).add(req);
            }

            if (currentDirection == Directions.DOWN && !downRequest.isEmpty() &&
                    currentFloor == floorFactory.getFloor(downRequest.peek().request.pickup())) {
                Request req = downRequest.poll().request;
                System.out.println("  Pickup at floor: " + req.pickup());
                dropFloor.computeIfAbsent(floorFactory.getFloor(req.drop()), k -> new ArrayList<>()).add(req);
            }

            move();
        }
    }

    private void move() {
        if (currentDirection == Directions.UP) {
            currentFloor++;
            if (currentFloor > totalFloor || (upRequest.isEmpty() && dropFloor.isEmpty())) {
                currentDirection = Directions.DOWN;
                currentFloor = Math.min(currentFloor, totalFloor);
                System.out.println("==> Switching direction to DOWN");
            }
        } else {
            currentFloor--;
            if (currentFloor < 0 || (downRequest.isEmpty() && dropFloor.isEmpty())) {
                currentDirection = Directions.UP;
                currentFloor = Math.max(currentFloor, 0);
                System.out.println("==> Switching direction to UP");
            }
        }
    }
}
