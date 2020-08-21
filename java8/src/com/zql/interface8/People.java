package com.zql.interface8;

/**
 * @author dell
 */
public interface People {

    /**
     * 接口默认方法
     */
    default void walk() {
        System.out.println("人会行走");
    }
}
