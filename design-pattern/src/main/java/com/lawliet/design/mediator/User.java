package com.lawliet.design.mediator;

/**
 * 进入聊天室的用户抽象类
 * @author dell
 */
public abstract class User {

    /**
     * 用户进入的聊天室
     */
    protected AbstractChatRoom chatRoom;

    public User(AbstractChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    /**
     * 发送消息
     * @param message 要发送到聊天室的消息
     */
    public abstract void sendMessage(String message);

    /**
     * 接收消息
     * @param message 从聊天室接收到的消息
     * @return 消息内容
     */
    public abstract void getMessage(String message);
}
