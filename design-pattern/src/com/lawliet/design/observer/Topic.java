package com.lawliet.design.observer;

/**
 * 主题接口
 * @author dell
 */
public interface Topic {

    /**
     * 注册观察者
     * @param observer 观察者对象
     */
    public void registerObserver(Observer observer);

    /**
     * 移除观察者
     * @param observer 观察者对象
     */
    public void removeObserver(Observer observer);

    /**
     * 通知所有的观察者
     */
    public void notifyAllObserver();

    /**
     * 获取订阅的主题名称
     * @return 主题名称
     */
    public String getName();

}
