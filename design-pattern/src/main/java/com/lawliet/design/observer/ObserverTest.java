package com.lawliet.design.observer;

/**
 * 观察者模式测试
 * @author dell
 */
public class ObserverTest {

    public static void main(String[] args) {
        VideoTopic videoTopic = new VideoTopic();
        videoTopic.registerObserver(new VideoUser("张三"));
        videoTopic.registerObserver(new VideoUser("李四"));
        videoTopic.registerObserver(new VideoUser("王五"));

        videoTopic.notifyAllObserver();
    }
}
