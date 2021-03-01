package com.lawliet.design.proxy;

/**
 * 狗吃饭
 * @author dell
 */
public class DogEatSubject implements EatSubject{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}
