package com.lawliet.design.proxy;

/**
 * 狗吃饭代理
 * @author dell
 */
public class DogEatProxy implements EatSubject{

    /**
     * 代理的目标
     */
    private EatSubject target;

    public DogEatProxy() {
        this.target = new DogEatSubject();
    }

    @Override
    public void eat() {
        // 代理可以对原方法进行一些增强
        System.out.println("去超市买骨头");
        target.eat();
        System.out.println("吃完扔掉");
    }
}
