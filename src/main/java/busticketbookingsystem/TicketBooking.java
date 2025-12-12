package busticketbookingsystem;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


class UserModel {
    private final int id;
    private String name;
    private String email;
    private String phone;

    public UserModel(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

class Route {
    private final String departure;
    private final String arrival;

    public Route(String departure, String arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }
    public String getDeparture() { return departure; }
    public String getArrival() { return arrival; }
}

class Schedule {
    private final String startTime;
    private final String endTime;

    public Schedule(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
}

enum SeatStatus {
    BOOKED,
    LOCKED,
    AVAILABLE
}

enum SeatType {
    SLEEPER,
    REGULAR
}

class Seat {
    private final int seatId;
    private SeatType seatType;
    private SeatStatus seatStatus;

    public Seat(int seatId, SeatType seatType, SeatStatus seatStatus) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }

    public int getSeatId() { return seatId; }
    public SeatType getSeatType() { return seatType; }
    public void setSeatType(SeatType seatType) { this.seatType = seatType; }
    public SeatStatus getSeatStatus() { return seatStatus; }
    public void setSeatStatus(SeatStatus seatStatus) { this.seatStatus = seatStatus; }
}

class BusModel {
    private final int busId;
    private String busNumber;
    private String driver;
    private Route route;
    private Schedule schedule;
    private Seat[][] seatMap; // kept 2D as you did, but each seat is unique
    private Double fare;

    public BusModel(int busId, String busNumber, String driver,
                    Route route, Schedule schedule, Seat[][] seatMap, Double fare) {
        this.busId = busId;
        this.busNumber = busNumber;
        this.driver = driver;
        this.route = route;
        this.schedule = schedule;
        this.seatMap = seatMap;
        this.fare = fare;
    }

    public int getBusId() { return busId; }
    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }
    public String getDriver() { return driver; }
    public void setDriver(String driver) { this.driver = driver; }
    public Route getRoute() { return route; }
    public void setRoute(Route route) { this.route = route; }
    public Schedule getSchedule() { return schedule; }
    public void setSchedule(Schedule schedule) { this.schedule = schedule; }
    public Seat[][] getSeatMap() { return seatMap; }
    public void setSeatMap(Seat[][] seatMap) { this.seatMap = seatMap; }
    public Double getFare() { return fare; }
    public void setFare(Double fare) { this.fare = fare; }

    // helper to get all seats as flat list
    public List<Seat> getAllSeats() {
        List<Seat> list = new ArrayList<>();
        for (Seat[] row : seatMap) {
            list.addAll(Arrays.asList(row));
        }
        return list;
    }
}

enum BookingStatus {
    CONFIRMED,
    PENDING,
    CANCELLED,
    FAILED
}

enum PaymentStatus {
    SUCCESS,
    FAILED,
    PENDING,
    REFUND
}

class BookingModel {
    private final int bookingId;
    private final String bookingUser;
    private final int busId;
    private final Route route;
    private final List<Integer> seatIds;
    private BookingStatus bookingStatus;
    private PaymentStatus paymentStatus;
    private Double amount;
    private final LocalDateTime createdAt;

    public BookingModel(int bookingId, String bookingUser, int busId, Route route,
                        List<Integer> seatIds, BookingStatus bookingStatus,
                        PaymentStatus paymentStatus, Double amount) {
        this.bookingId = bookingId;
        this.bookingUser = bookingUser;
        this.busId = busId;
        this.route = route;
        this.seatIds = new ArrayList<>(seatIds);
        this.bookingStatus = bookingStatus;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
    }

    public int getBookingId() { return bookingId; }
    public String getBookingUser() { return bookingUser; }
    public int getBusId() { return busId; }
    public Route getRoute() { return route; }
    public List<Integer> getSeatIds() { return Collections.unmodifiableList(seatIds); }
    public BookingStatus getBookingStatus() { return bookingStatus; }
    public void setBookingStatus(BookingStatus bookingStatus) { this.bookingStatus = bookingStatus; }
    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

class UserService {
    private final Map<Integer, UserModel> users = new HashMap<>();

    public boolean addUser(UserModel user) {
        if (users.containsKey(user.getId())) {
            throw new RuntimeException("User already exists");
        }
        users.put(user.getId(), user);
        return true;
    }

    public Optional<UserModel> getUser(int id) {
        return Optional.ofNullable(users.get(id));
    }
}

class BusService {
    private final Map<Integer, BusModel> buses = new HashMap<>();
    private final AtomicInteger seatIdGenerator = new AtomicInteger(0);

    public BusModel createBus(int busId, String busNumber, String driver,
                              String departure, String arrival, String startTime,
                              String endTime, Double fare, int rows, int cols) {

        if (buses.containsKey(busId)) {
            throw new RuntimeException("Bus already exists with id: " + busId);
        }

        Route route = new Route(departure, arrival);
        Schedule schedule = new Schedule(startTime, endTime);

        Seat[][] seats = new Seat[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int id = seatIdGenerator.incrementAndGet();
                seats[i][j] = new Seat(id, SeatType.REGULAR, SeatStatus.AVAILABLE);
            }
        }

        BusModel bus = new BusModel(busId, busNumber, driver, route, schedule, seats, fare);
        buses.put(busId, bus);
        System.out.println("Bus created successfully: " + busId);
        return bus;
    }

    public BusModel getBusById(int busId) {
        BusModel bus = buses.get(busId);
        if (bus == null) throw new RuntimeException("Bus not found for id: " + busId);
        return bus;
    }

    public void showBusDetails(BusModel bus) {
        System.out.println("BusId: " + bus.getBusId());
        System.out.println("BusNumber: " + bus.getBusNumber());
        System.out.println("Bus Route-[Departure,Arrival] [ " +
                bus.getRoute().getDeparture() + "," + bus.getRoute().getArrival() + " ]");
        System.out.println("Bus Schedule-[startTime,endTime] [ " +
                bus.getSchedule().getStartTime() + "," + bus.getSchedule().getEndTime() + " ]");
        System.out.println("Bus Fare: " + bus.getFare());
    }

    public void showSeatsByBusId(int busId) {
        BusModel bus = getBusById(busId);
        Seat[][] seats = bus.getSeatMap();
        for (Seat[] row : seats) {
            for (Seat s : row) {
                showSeatDetail(s);
            }
        }
    }

    public void showSeatDetail(Seat seat) {
        System.out.println("SeatId: " + seat.getSeatId() +
                ", SeatType: " + seat.getSeatType() +
                ", SeatStatus: " + seat.getSeatStatus());
    }

    public List<BusModel> searchBusByRoute(Route route) {
        List<BusModel> results = new ArrayList<>();
        for (BusModel bus : buses.values()) {
            Route r = bus.getRoute();
            if (r.getArrival().equals(route.getArrival()) && r.getDeparture().equals(route.getDeparture())) {
                results.add(bus);
            }
        }
        return results;
    }

    // find seat by id in given bus
    public Seat findSeatById(BusModel bus, int seatId) {
        for (Seat s : bus.getAllSeats()) {
            if (s.getSeatId() == seatId) return s;
        }
        throw new RuntimeException("Seat not found: " + seatId);
    }

    // update seat status (caller must ensure concurrency)
    public void updateSeatStatus(BusModel bus, int seatId, SeatStatus status) {
        Seat seat = findSeatById(bus, seatId);
        seat.setSeatStatus(status);
    }
}

class BookingService {
    private final AtomicInteger bookingId = new AtomicInteger(100);
    private final Map<Integer, BookingModel> bookingMap = new HashMap<>();
    private final BusService busService;

    public BookingService(BusService busService) {
        this.busService = busService;
    }

    /**
     * Creates a booking in the steps:
     * 1) Validate seat ids exist and are AVAILABLE
     * 2) Lock seats (set LOCKED)
     * 3) Simulate payment
     * 4) If payment success -> BOOKED else release LOCKED -> AVAILABLE
     *
     * The whole booking operation for the bus is synchronized on the BusModel instance
     * to prevent concurrent modifications on the same bus seats.
     */
    public BookingModel createBooking(String bookingUser, int busId, Double amount, List<Integer> seatIds) {
        if (seatIds == null || seatIds.isEmpty()) {
            throw new IllegalArgumentException("At least one seat must be selected");
        }

        BusModel bus = busService.getBusById(busId);
        double expectedAmount = seatIds.size() * bus.getFare();
        boolean paymentSuccess = false;

        synchronized (bus) { // simple concurrency control per bus
            // 1. Validate all seats are AVAILABLE
            for (int seatId : seatIds) {
                Seat s = busService.findSeatById(bus, seatId);
                if (s.getSeatStatus() != SeatStatus.AVAILABLE) {
                    throw new RuntimeException("Seat not available: " + seatId);
                }
            }

            // 2. Lock seats
            for (int seatId : seatIds) {
                busService.updateSeatStatus(bus, seatId, SeatStatus.LOCKED);
            }

            // 3. Payment simulation: check amount
            if (!Objects.equals(expectedAmount, amount)) {
                System.out.printf("Insufficient amount. Required=%.2f Provided=%.2f%n", expectedAmount, amount);
                paymentSuccess = false;
            } else {
                // Simulate external payment -> here we assume success
                paymentSuccess = true;
            }

            // 4. Mark seats BOOKED or release locks depending on payment
            if (paymentSuccess) {
                for (int seatId : seatIds) {
                    busService.updateSeatStatus(bus, seatId, SeatStatus.BOOKED);
                }
            } else {
                for (int seatId : seatIds) {
                    busService.updateSeatStatus(bus, seatId, SeatStatus.AVAILABLE);
                }
            }
        } // end synchronized

        int id = bookingId.incrementAndGet();
        BookingModel booking;
        if (paymentSuccess) {
            booking = new BookingModel(id, bookingUser, busId, bus.getRoute(), seatIds,
                    BookingStatus.CONFIRMED, PaymentStatus.SUCCESS, amount);
            bookingMap.put(id, booking);
            System.out.println("Booking confirmed: " + id);
        } else {
            booking = new BookingModel(id, bookingUser, busId, bus.getRoute(), seatIds,
                    BookingStatus.FAILED, PaymentStatus.FAILED, amount);
            bookingMap.put(id, booking);
            System.out.println("Booking failed: " + id);
        }
        return booking;
    }

    public Optional<BookingModel> getBooking(int bookingId) {
        return Optional.ofNullable(bookingMap.get(bookingId));
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        System.out.println("This is bus ticket booking LLD");

        UserModel user1 = new UserModel(1, "himanshu", "hs@gmail.com", "824234");

        BusService busService = new BusService();

        // create a bus with 5 rows x 5 cols (25 seats)
        BusModel bus = busService.createBus(2, "KA1234", "Gondu", "delhi", "agra",
                "10:00PM", "12:00PM", 500.0, 5, 5);

        List<BusModel> found = busService.searchBusByRoute(new Route("delhi", "agra"));
        if (!found.isEmpty()) {
            System.out.println("Found buses:");
            for (BusModel b : found) {
                busService.showBusDetails(b);
            }
        }

        busService.showSeatsByBusId(bus.getBusId());

        BookingService bookingService = new BookingService(busService);

        // try booking seats 1 and 2 with correct amount
        List<Integer> seatsToBook = List.of(1, 2);
        BookingModel booking = bookingService.createBooking(user1.getName(), bus.getBusId(), 1000.0, seatsToBook);

        System.out.println("Booking id: " + booking.getBookingId() + " status: " + booking.getBookingStatus());

        // show seats after booking
        busService.showSeatsByBusId(bus.getBusId());
    }
}
