package PubSubImplementation;

public interface MessagingQueue {

     void subscribe(ConsumerInterface consumerInterface);
     void publish (String message);

}
