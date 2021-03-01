package com.lawliet.design.builder;

/**
 * @author dell
 */
public class VegBurger extends BaseBurger {

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
