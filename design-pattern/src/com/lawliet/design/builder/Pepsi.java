package com.lawliet.design.builder;

/**
 * @author dell
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "百事可乐";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
