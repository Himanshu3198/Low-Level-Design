package org.designPattern.MediatorPattern;

public class ChatRoomDemo {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User user1 = new ChatUser(chatRoom, "Alice");
        User user2 = new ChatUser(chatRoom, "Bob");
        User user3 = new ChatUser(chatRoom, "Mike");
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);
        user1.sendMessage("Hello there how are you doing ?");
        user2.sendMessage("I am good !");

    }
}
