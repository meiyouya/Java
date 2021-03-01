package com.lawliet.design.singleton;

/**
 * 懒汉式单例模式
 * @author dell
 */
public class LazySingleton {

    /**
     * 程序不会在一开始就将对象创建好
     */
    private static LazySingleton singleton;

    /**
     * 私有构造方法，因为单例模式不应该支持在外部创建对象
     */
    private LazySingleton(){}

    /**
     * 获取单例对象
     * 在第一次获取时，会创建单例对象
     * 但是如果在并发情况下，会创建多个实例，单例模式就会失去意义
     * @return 单例对象
     */
    public static LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
