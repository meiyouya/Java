package com.lawliet.design.builder;

/**
 * @author dell
 */
public class ChickenBurger extends BaseBurger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.0f;
    }
}
