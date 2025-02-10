package PubSubImplementation;

import java.util.ArrayList;
import java.util.List;

public interface ConsumerInterface {

    void consume(String message);

    class OperationService implements MessagingQueue {

        List<ConsumerInterface> subscriber = new ArrayList<>();
        @Override
        public void subscribe(ConsumerInterface consumerInterface) {
            subscriber.add(consumerInterface);
            System.out.println("Consumer has been subscribed");
        }

        @Override
        public void publish(String message) {

            System.out.println("New message published: "+message);
            notifyConsumers(message);
        }

        public void notifyConsumers(String message){
            for(ConsumerInterface consumerInterface:subscriber){
                consumerInterface.consume(message);
            }
        }
    }
}
