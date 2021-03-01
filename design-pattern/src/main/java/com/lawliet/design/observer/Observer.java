package com.lawliet.design.observer;

/**
 * 观察者接口
 * @author dell
 */
public interface Observer {

    /**
     * 提醒观察者，订阅的主题有更新了
     * @param topic 更新的主题
     */
    public void notify(Topic topic);
}
