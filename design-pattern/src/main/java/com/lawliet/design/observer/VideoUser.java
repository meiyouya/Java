package com.lawliet.design.observer;

/**
 * 使用这个视频网站的用户
 * 每个用户都是这个视频网站的一个观察者，即订阅者
 * @author dell
 */
public class VideoUser implements Observer{

    /**
     * 用户名
     */
    private String username;

    public VideoUser(String username) {
        this.username = username;
    }

    @Override
    public void notify(Topic topic) {
        System.out.println("您好：" + this.username + "，您订阅的：《" + topic.getName() + "》已经更新了，赶快去看吧！！");
    }
}
