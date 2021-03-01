package com.lawliet.design.singleton;

/**
 * 静态内部类实现单例模式
 * @author dell
 */
public class StaticInnerClassSingleton {

    /**
     * 首先使用静态内部类，在外部类加载的时候，这个类并不会一同加载
     * 因为它虽然是内部类，但是类与类之间的加载并不会影响
     * 所以，这里实际上是和懒汉式一样，等到调用时对象才会创建
     * 这种方式有个缺点，就是说，创建单例对象的时候，无法进行传参。也就是说，只能创建一个空对象
     * 如果单例对象还有其它成员需要初始化，就无法实现
     */
    private static class SingletonHolder {
        private static final StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton() {}

    /**
     * 获取单例对象
     * 获取时，直接返回静态内部类的成员，第一次调用时，这个静态内部类才会初始化
     * 由于在同一个类加载器下，一个类只会被初始化一次
     * 所以这个对象也一定只会被创建一次，所以一定是线程安全的
     * 而且这里只是将静态内部类的成员拿出来返回，所以不管多少个线程来取，取到的都是同一个成员的引用
     * @return 单例对象
     */
    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.singleton;
    }
}
