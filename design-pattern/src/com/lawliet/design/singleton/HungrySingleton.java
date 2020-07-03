package com.lawliet.design.singleton;

/**
 * 饿汉式单例模式
 * @author dell
 */
public class HungrySingleton {

    /**
     * 程序会直接加载一个已经创建好的实例
     */
    private static final HungrySingleton singleton = new HungrySingleton();

    /**
     * 私有构造方法，因为单例模式不应该支持在外部创建对象
     */
    private HungrySingleton(){}

    /**
     * 获取已经创建好的实例
     * @return 单例对象
     */
    public static HungrySingleton getInstance() {
        return singleton;
    }
}
