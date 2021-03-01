package com.lawliet.design.factory;

/**
 * 女人
 * @author dell
 */
public class Female implements Human{
    @Override
    public void eat() {
        System.out.println("女人不能为了瘦吃太少");
    }

    @Override
    public void sleep() {
        System.out.println("女人睡得充足才能皮肤好");
    }

    @Override
    public void work() {
        System.out.println("女人工作不要太累");
    }
}
