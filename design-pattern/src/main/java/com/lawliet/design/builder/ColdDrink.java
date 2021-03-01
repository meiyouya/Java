package com.lawliet.design.builder;

/**
 * @author dell
 */
public abstract class ColdDrink implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }

    /**
     * 价格
     * @return
     */
    @Override
    public abstract float price();
}
