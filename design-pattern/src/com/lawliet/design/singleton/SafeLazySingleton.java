package com.lawliet.design.singleton;

/**
 * 线程安全的懒汉式单例模式
 * @author dell
 */
public class SafeLazySingleton {

    /**
     * 程序不会在一开始就将对象创建好
     */
    private static SafeLazySingleton singleton;

    /**
     * 私有构造方法，因为单例模式不应该支持在外部创建对象
     */
    private SafeLazySingleton(){}

    /**
     * 获取单例对象
     * 在第一次获取时，会创建单例对象
     * 使用synchronized使这个方法变为同步，保证只会创建一个对象
     * 但是由于直接把方法锁了，每次调用都是同步的，效率很低
     * @return 单例对象
     */
    public static synchronized SafeLazySingleton getInstance() {
        if (singleton == null) {
            singleton = new SafeLazySingleton();
        }
        return singleton;
    }
}
