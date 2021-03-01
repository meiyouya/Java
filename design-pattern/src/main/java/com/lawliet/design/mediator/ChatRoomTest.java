package com.lawliet.design.mediator;

/**
 * @author dell
 */
public class ChatRoomTest {

    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        UserA userA = new UserA(chatRoom);
        UserB userB = new UserB(chatRoom);
        chatRoom.login(userA);
        chatRoom.login(userB);
        userA.sendMessage("hello B");
        userB.sendMessage("hello A");
    }
}
