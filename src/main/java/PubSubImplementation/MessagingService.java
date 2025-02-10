package PubSubImplementation;

public class MessagingService {

    public static void main(String[] args) {
      OperationService  queue = new OperationService();

          CreateSubscriber consumer1 = new CreateSubscriber("Consumer1");
          CreateSubscriber consumer2 = new CreateSubscriber("Consumer2");
          CreateSubscriber consumer3 = new CreateSubscriber("Consumer3");
          queue.subscribe(consumer1);
          queue.subscribe(consumer2);
          queue.subscribe(consumer3);
          PublisherService msgPublisher = new PublisherService(queue);
          msgPublisher.publishMessage("Hi this a mew message");
          msgPublisher.publishMessage("it is all about learning new things");
          msgPublisher.publishMessage("pain of discipline is better than pain of regret");

    }

}
