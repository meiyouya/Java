package com.lawliet.design.builder;

/**
 * 食物条目
 * @author dell
 */
public interface Item {

    /**
     * 食物名称
     * @return 食物名称
     */
    String name();

    /**
     * 打包
     * @return 包装
     */
    Packing packing();

    /**
     * 食物单价
     * @return 食物单价
     */
    float price();
}
