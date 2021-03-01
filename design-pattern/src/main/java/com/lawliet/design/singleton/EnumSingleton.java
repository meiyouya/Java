package com.lawliet.design.singleton;

/**
 * 使用枚举实现单例
 * @author dell
 */

public enum EnumSingleton {

    /**
     * 只有一个实例，枚举创建的时候默认就是线程安全的
     * 还可以防止反序列化带来的问题
     */
    INSTANCE;
}
