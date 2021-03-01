package com.lawliet.design.proxy;

import com.lawliet.design.proxy.jdk.JdkEatProxy;

/**
 * @author dell
 */
public class ProxyTest {

    public static void main(String[] args) {
        // 手动实现的代理模式（又称静态代理）
//        EatSubject proxy = new DogEatProxy();
//        proxy.eat();

        // jdk动态代理
        JdkEatProxy eatProxy = new JdkEatProxy();
        // JDK的动态代理是实现了一个接口的匿名实现类，所以目标对象必须实现了某个接口
        // 且必须使用目标对象实现的接口去接收代理对象，否则会抛出异常
        // com.sun.proxy.$Proxy0 cannot be cast to com.lawliet.design.proxy.DogEatSubject
        EatSubject dogEatSubject = (EatSubject) eatProxy.newProxy(new DogEatSubject());
        EatSubject eatEatSubject = (EatSubject) eatProxy.newProxy(new CatEatSubject());
        dogEatSubject.eat();
        eatEatSubject.eat();

        // cglib动态代理
//        CglibDogEatProxy cglibDogEatProxy = new CglibDogEatProxy();
        // CGLIB是使用的是继承的方式，所以使用接口或者实现类去接收都可以，它只是作为代理对象的一个父类而已
//        DogEatSubject eatSubject = (DogEatSubject) cglibDogEatProxy.createProxyObject(new DogEatSubject());
//        EatSubject eatSubject = (EatSubject) cglibDogEatProxy.createProxyObject(new DogEatSubject());
//        eatSubject.eat();
    }
}
