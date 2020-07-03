package com.lawliet.design.factory;

/**
 * 男人
 * @author dell
 */
public class Male implements Human{
    @Override
    public void eat() {
        System.out.println("男人要多吃肉，身体才能强壮");
    }

    @Override
    public void sleep() {
        System.out.println("男人少睡觉，多挣钱");
    }

    @Override
    public void work() {
        System.out.println("男人工作别怕累");
    }
}
