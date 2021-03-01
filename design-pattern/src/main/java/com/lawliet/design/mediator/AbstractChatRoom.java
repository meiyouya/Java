package com.lawliet.design.mediator;

/**
 * 抽象聊天室，在中介模式中，作为中介对象
 * @author dell
 */
public abstract class AbstractChatRoom {

    /**
     * 新消息提醒
     * @param message 消息内容
     * @param user 消息发送者
     */
    public abstract void notice(String message, User user);
}
