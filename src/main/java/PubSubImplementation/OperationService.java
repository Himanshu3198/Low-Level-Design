package PubSubImplementation;

import java.util.ArrayList;
import java.util.List;

public class OperationService implements  MessagingQueue{
    List<ConsumerInterface> subscriber = new ArrayList<>();
    @Override
    public void subscribe(ConsumerInterface consumerInterface) {
          subscriber.add(consumerInterface);
    }

    @Override
    public void publish(String message) {
        System.out.println("New message received: "+message);
        notifyConsumer(message);
    }
    public void notifyConsumer(String message){
        for(ConsumerInterface consumerInterface:subscriber){
            consumerInterface.consume(message);
        }
    }
}
