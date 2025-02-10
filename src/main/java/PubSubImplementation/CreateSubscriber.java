package PubSubImplementation;

public class CreateSubscriber implements  ConsumerInterface{

    String name;
    public CreateSubscriber(String name){
        this.name = name;
    }
    @Override
    public void consume(String message) {
        System.out.println(name + " has received the message: "+message);
    }
}
