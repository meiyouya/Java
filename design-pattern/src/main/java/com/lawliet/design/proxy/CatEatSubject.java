package com.lawliet.design.proxy;

/**
 * 猫吃老鼠
 * @author dell
 */
public class CatEatSubject implements EatSubject{
    @Override
    public void eat() {
        System.out.println("猫吃老鼠");
    }
}
