package com.lawliet.design.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室
 * @author dell
 */
public class ChatRoom extends AbstractChatRoom{

    /**
     * 聊天室中的用户列表
     */
    private List<User> users = new ArrayList<>();

    /**
     * 用户登入聊天室
     * @param user 用户信息
     */
    public void login(User user) {
        users.add(user);
    }

    @Override
    public void notice(String message, User user) {
        for (User u : users) {
            if (u != user) {
                // 接收别人发的消息
                u.getMessage(message);
            }
        }
    }
}
