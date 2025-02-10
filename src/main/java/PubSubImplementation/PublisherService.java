package PubSubImplementation;

public class PublisherService {
    private  OperationService operationService;

     public PublisherService(OperationService operationService){
         this.operationService = operationService;
     }

     public void publishMessage(String message){
         operationService.publish(message);
     }
}
