package com.lawliet.design.proxy;

/**
 * @author dell
 */
public class ProxyTest {

    public static void main(String[] args) {
        EatSubject proxy = new DogEatProxy();
        proxy.eat();
    }
}
