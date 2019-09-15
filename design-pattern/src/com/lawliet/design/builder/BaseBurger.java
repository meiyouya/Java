package com.lawliet.design.builder;

/**
 * @author dell
 */
public abstract class BaseBurger implements Item {

    @Override
    public Packing packing() {
        return new PackingWrapper();
    }

    /**
     * 价格
     * @return 食物单价
     */
    @Override
    public abstract float price();
}
