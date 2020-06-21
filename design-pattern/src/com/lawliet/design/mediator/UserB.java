package com.lawliet.design.mediator;

/**
 * @author dell
 */
public class UserB extends User{

    public UserB(AbstractChatRoom chatRoom) {
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
