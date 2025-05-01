package BookMyShow.Service;

import BookMyShow.Model.User;

public class NotificationService {

           public void sendNotification(User user, String message){
               user.addNotification(message);
               System.out.println("Notification for "+user.getUserName()+" message: "+message);
           }
           public void showNotification(User user){
               for(String record:user.getNotification()){
                   System.out.println(record);
               }
           }
}
