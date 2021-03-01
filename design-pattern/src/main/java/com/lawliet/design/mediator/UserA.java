package com.lawliet.design.mediator;

/**
 * @author dell
 */
public class UserA extends User{

    public UserA(AbstractChatRoom chatRoom) {
        super(chatRoom);
    }

    @Override
    public void sendMessage(String message) {
        chatRoom.notice(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println(message);
    }
}
