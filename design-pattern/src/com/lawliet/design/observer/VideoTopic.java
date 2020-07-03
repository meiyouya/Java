package com.lawliet.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 视频主题
 * @author dell
 */
public class VideoTopic implements Topic{

    /*
    观察者列表，即订阅者的列表
     */
    private List<Observer> observerList;

    /*
    视频列表，即网站有哪些视频，正常的业务来说，这个应该是数据库中得来的
     */
    private List<String> videoList;

    public VideoTopic() {
        this.observerList = new ArrayList<>();
        this.videoList = new ArrayList<>();

        // 新增一些视频，模拟已有很多视频
        videoList.add("隐秘的角落");
        videoList.add("战狼2");
        videoList.add("风语咒");
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer : observerList) {
            observer.notify(this);
        }
    }

    @Override
    public String getName() {
        // 正常的业务。这里会从数据库或者mq等其他地方获取，这里先固定返回一个值，模拟一下即可
        return videoList.get(2);
    }
}
