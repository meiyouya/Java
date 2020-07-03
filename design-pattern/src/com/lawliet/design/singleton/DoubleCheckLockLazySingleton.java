package com.lawliet.design.singleton;

/**
 * 双重检验锁的懒汉式单例模式
 * @author lawliet.L
 */
public class DoubleCheckLockLazySingleton {

    /**
     * 程序不会在一开始就将对象创建好
     * 这里之所以使用volatile，是因为JVM为了优化代码，可能会造成指令重叠，导致创建出多个对象
     */
    private volatile static DoubleCheckLockLazySingleton singleton;

    /**
     * 私有构造方法，因为单例模式不应该支持在外部创建对象
     */
    private DoubleCheckLockLazySingleton(){}

    /**
     * 获取单例对象
     * 使用双重检验锁
     * 双重检验锁的原理是：
     * 1. 在最外部判空，保证一旦对象被创建，之后调用getInstance可以立即返回单例对象
     * 2. 同步代码块移到第一次判空的内部，保证对象被创建后，多线程调用getInstance的效率
     * 3. 同步代码块中再次判空，保证如果有多个线程走入了第一次判空，可以只创建一个对象
     * @return 单例对象
     */
    public static DoubleCheckLockLazySingleton getInstance() {
        // 可以确定的是，必须singleton==null才走进创建对象的逻辑
        // 这一步判空的主要目的是解决第一次访问getInstance后单例对象已经被创建
        // 后面多次访问getInstance可以直接返回，不会因为synchronized影响效率
        if (singleton == null) {
            // 这里会有多个线程进来，所以接下来的代码块要用synchronized加锁
            // 把synchronized移到里面可以保证，第一次调用getInstance创建对象时不会创建多个
            // 同时使后续调用getInstance时不会走到同步代码块
            synchronized (DoubleCheckLockLazySingleton.class) {
                // 加锁的代码块要再次判空，因为上一步有多个线程会执行下面的命令
                // 再次判空保证只会创建一个对象
                if (singleton == null) {
                    singleton = new DoubleCheckLockLazySingleton();
                }
            }
        }
        return singleton;
    }
}
