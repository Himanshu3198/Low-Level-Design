package dsalldmix;

import java.util.*;

/* =======================
   ENUMS
   ======================= */

enum Severity {
    HIGH,
    MEDIUM,
    LOW
}

enum Channel {
    EMAIL,
    SMS,
    PHONE
}

/* =======================
   NOTIFICATION MODEL
   ======================= */

class Notification {
    private final int clientId;
    private final Severity severity;
    private final String message;

    public Notification(int clientId, Severity severity, String message) {
        this.clientId = clientId;
        this.severity = severity;
        this.message = message;
    }

    public int getClientId() {
        return clientId;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }
}

/* =======================
   OBSERVER PATTERN
   ======================= */

interface Observer {
    void notify(Notification notification);
}

interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void publish(Notification notification);
}

/* =======================
   CLIENT (SUBJECT)
   ======================= */

class Client implements Subject {

    private final int id;
    private final String name;
    private final Set<Observer> subscribers = new HashSet<>();

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void publish(Notification notification) {
        subscribers.forEach(sub -> sub.notify(notification));
    }
}

/* =======================
   STRATEGY PATTERN
   ======================= */

interface ChannelStrategy {
    void send(Notification notification, Subscriber subscriber);
}

class EmailNotification implements ChannelStrategy {
    @Override
    public void send(Notification notification, Subscriber subscriber) {
        System.out.println(
                "EMAIL -> " + subscriber.getUserName()
                        + " | " + notification.getMessage()
        );
    }
}

class SmsNotification implements ChannelStrategy {
    @Override
    public void send(Notification notification, Subscriber subscriber) {
        System.out.println(
                "SMS -> " + subscriber.getUserName()
                        + " | " + notification.getMessage()
        );
    }
}

class PhoneNotification implements ChannelStrategy {
    @Override
    public void send(Notification notification, Subscriber subscriber) {
        System.out.println(
                "PHONE -> " + subscriber.getUserName()
                        + " | " + notification.getMessage()
        );
    }
}

/* =======================
   FACTORY
   ======================= */

class ChannelFactory {

    private final Map<Channel, ChannelStrategy> registry = new HashMap<>();

    public ChannelFactory() {
        registry.put(Channel.EMAIL, new EmailNotification());
        registry.put(Channel.SMS, new SmsNotification());
        registry.put(Channel.PHONE, new PhoneNotification());
    }

    public ChannelStrategy get(Channel channel) {
        if (!registry.containsKey(channel)) {
            throw new IllegalArgumentException("Unsupported channel: " + channel);
        }
        return registry.get(channel);
    }
}

/* =======================
   CHANNEL RESOLVER
   ======================= */

interface ChannelResolver {
    List<Channel> resolve(int clientId, int subscriberId, Severity severity);
}

/*
 clientId
    -> subscriberId
        -> severity
            -> channels
 */
class InMemoryChannelResolver implements ChannelResolver {

    private final Map<Integer,
            Map<Integer,
                    Map<Severity, List<Channel>>>> strategyMap = new HashMap<>();

    public void addStrategy(
            int clientId,
            int subscriberId,
            Severity severity,
            List<Channel> channels
    ) {
        strategyMap
                .computeIfAbsent(clientId, k -> new HashMap<>())
                .computeIfAbsent(subscriberId, k -> new HashMap<>())
                .put(severity, channels);
    }

    @Override
    public List<Channel> resolve(int clientId, int subscriberId, Severity severity) {
        return strategyMap
                .getOrDefault(clientId, Collections.emptyMap())
                .getOrDefault(subscriberId, Collections.emptyMap())
                .getOrDefault(severity, Collections.emptyList());
    }
}

/* =======================
   SUBSCRIBER (OBSERVER)
   ======================= */

class Subscriber implements Observer {

    private final int id;
    private final String userName;
    private final ChannelResolver resolver;
    private final ChannelFactory factory;

    public Subscriber(
            int id,
            String userName,
            ChannelResolver resolver,
            ChannelFactory factory
    ) {
        this.id = id;
        this.userName = userName;
        this.resolver = resolver;
        this.factory = factory;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public void notify(Notification notification) {

        List<Channel> channels =
                resolver.resolve(
                        notification.getClientId(),
                        id,
                        notification.getSeverity()
                );

        channels.forEach(channel ->
                factory.get(channel)
                        .send(notification, this)
        );
    }
}

/* =======================
   DEMO / MAIN
   ======================= */

public class NotificationServiceAmazon {

    public static void main(String[] args) {

        ChannelFactory channelFactory = new ChannelFactory();
        InMemoryChannelResolver resolver = new InMemoryChannelResolver();

        Client amazon = new Client(1, "Amazon");
        Client aws = new Client(2, "AWS");

        Subscriber subscriber =
                new Subscriber(101, "Himanshu", resolver, channelFactory);

        amazon.subscribe(subscriber);
        aws.subscribe(subscriber);

        // Amazon strategies
        resolver.addStrategy(
                1, 101, Severity.HIGH,
                List.of(Channel.EMAIL, Channel.SMS)
        );
        resolver.addStrategy(
                1, 101, Severity.MEDIUM,
                List.of(Channel.EMAIL)
        );
        resolver.addStrategy(
                1, 101, Severity.LOW,
                List.of(Channel.EMAIL)
        );

        // AWS strategies
        resolver.addStrategy(
                2, 101, Severity.HIGH,
                List.of(Channel.PHONE)
        );
        resolver.addStrategy(
                2, 101, Severity.LOW,
                List.of(Channel.SMS)
        );

        System.out.println("---- Amazon HIGH ----");
        amazon.publish(new Notification(1, Severity.HIGH, "Order shipped"));

        System.out.println("---- AWS HIGH ----");
        aws.publish(new Notification(2, Severity.HIGH, "EC2 instance down"));

        System.out.println("---- Amazon LOW ----");
        amazon.publish(new Notification(1, Severity.LOW, "Price drop alert"));
    }
}