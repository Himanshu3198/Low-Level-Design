package AmazonLockerSystem;

import java.util.*;

/* ================================
   ENUMS
   ================================ */

enum LockerSize {
    SMALL, MEDIUM, LARGE
}

enum LockerStatus {
    LOCKED, AVAILABLE
}

/* ================================
   PACKAGE
   ================================ */

class Package {

    private int id;
    private int belongTo;
    private LockerSize size;

    public Package(int id, int belongTo, LockerSize size) {
        this.id = id;
        this.belongTo = belongTo;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public int getBelongTo() {
        return belongTo;
    }

    public LockerSize getSize() {
        return size;
    }
}

/* ================================
   LOCKER
   ================================ */

class Locker {

    private int lockerId;
    private int packageId = -1;
    private LockerSize lockerSize;
    private LockerStatus lockerStatus;
    private String pin;

    public Locker(int lockerId, LockerSize lockerSize) {
        this.lockerId = lockerId;
        this.lockerSize = lockerSize;
        this.lockerStatus = LockerStatus.AVAILABLE;
    }

    public synchronized boolean assignLocker(Package deliveryPackage, String pin) {

        if (lockerStatus != LockerStatus.AVAILABLE) {
            throw new IllegalArgumentException("Locker not available");
        }

        lockerStatus = LockerStatus.LOCKED;
        packageId = deliveryPackage.getId();
        this.pin = pin;

        System.out.println(
                "Locker " + lockerId +
                        " assigned to package " + deliveryPackage.getId() +
                        " | PIN: " + pin
        );
        return true;
    }

    public synchronized boolean openLocker(int packageId, String inputPin) {

        if (this.packageId != packageId) {
            System.out.println("Package ID mismatch!");
            return false;
        }

        if (!pin.equals(inputPin)) {
            System.out.println("Incorrect PIN!");
            return false;
        }

        System.out.println("Locker " + lockerId + " opened. Package collected.");

        lockerStatus = LockerStatus.AVAILABLE;
        this.packageId = -1;
        this.pin = null;
        return true;
    }

    public LockerSize getLockerSize() {
        return lockerSize;
    }

    public LockerStatus getLockerStatus() {
        return lockerStatus;
    }

    public String getPin(){
        return pin;
    }
}

/* ================================
   LOCATION
   ================================ */

record Coordinates(int x, int y) {}

class LockerLocation {

    private int locationId;
    private Coordinates coordinates;
    List<Locker> lockerList = new ArrayList<>();

    public LockerLocation(int locationId, Coordinates coordinates) {
        this.locationId = locationId;
        this.coordinates = coordinates;
    }

    public void addLocker(Locker locker) {
        lockerList.add(locker);
    }

    public List<Locker> getLockers() {
        return lockerList;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getLocationId() {
        return locationId;
    }
}

/* ================================
   STRATEGY
   ================================ */

interface AssignLockerStrategy {
    Locker findLocker(List<LockerLocation> locations,
                      Package pkg,
                      Coordinates receiverCoordinates);
}

record DistanceResolver(int dist, LockerLocation lockerLocation) {}

class SizeAndDistanceBasedStrategy implements AssignLockerStrategy {

    @Override
    public Locker findLocker(List<LockerLocation> locations,
                             Package pkg,
                             Coordinates receiverCoordinates) {

        PriorityQueue<DistanceResolver> pq =
                new PriorityQueue<>(Comparator.comparingInt(DistanceResolver::dist));

        for (LockerLocation location : locations) {
            int dist = calculateDistance(location.getCoordinates(), receiverCoordinates);
            pq.add(new DistanceResolver(dist, location));
        }

        while (!pq.isEmpty()) {
            LockerLocation nearest = pq.poll().lockerLocation();
            for (Locker locker : nearest.getLockers()) {
                if (locker.getLockerStatus() == LockerStatus.AVAILABLE &&
                        locker.getLockerSize() == pkg.getSize()) {
                    return locker;
                }
            }
        }
        throw new RuntimeException("No suitable locker found");
    }

    private int calculateDistance(Coordinates a, Coordinates b) {
        int dx = a.x() - b.x();
        int dy = a.y() - b.y();
        return (int) Math.sqrt(dx * dx + dy * dy);
    }
}

/* ================================
   LOCKER MANAGER
   ================================ */

class LockerManager {

    private List<LockerLocation> locationList;
    private AssignLockerStrategy lockerStrategy;
    private static final Random random = new Random();

    public LockerManager(AssignLockerStrategy lockerStrategy,
                         List<LockerLocation> locationList) {
        this.lockerStrategy = lockerStrategy;
        this.locationList = locationList;
    }

    public Locker assignLocker(Package pkg, Coordinates coordinates) {

        Locker locker =
                lockerStrategy.findLocker(locationList, pkg, coordinates);

        locker.assignLocker(pkg, generatePin());
        return locker;
    }

    private static String generatePin() {
        return String.valueOf(1000 + random.nextInt(9000));
    }
}

/* ================================
   DEMO / SIMULATION
   ================================ */

public class LockerSystemDemo {

    public static void main(String[] args) {

        LockerLocation loc1 =
                new LockerLocation(1, new Coordinates(0, 0));
        loc1.addLocker(new Locker(101, LockerSize.SMALL));
        loc1.addLocker(new Locker(102, LockerSize.MEDIUM));

        LockerLocation loc2 =
                new LockerLocation(2, new Coordinates(10, 10));
        loc2.addLocker(new Locker(201, LockerSize.SMALL));
        loc2.addLocker(new Locker(202, LockerSize.LARGE));

        List<LockerLocation> locations = List.of(loc1, loc2);

        AssignLockerStrategy strategy =
                new SizeAndDistanceBasedStrategy();

        LockerManager manager =
                new LockerManager(strategy, locations);

        Package pkg1 = new Package(1, 101, LockerSize.SMALL);
        Package pkg2 = new Package(2, 102, LockerSize.LARGE);

        System.out.println("\n--- Assign Lockers ---");
        Locker locker1 = manager.assignLocker(pkg1, new Coordinates(1, 1));
        Locker locker2 = manager.assignLocker(pkg2, new Coordinates(9, 9));

        System.out.println("\n--- Pickup Attempt ---");
        locker1.openLocker(1, "0000"); // wrong PIN

        // correct pin
        String  mypin = locker1.getPin();
        locker1.openLocker(1,mypin);

    }
}
