package com.lawliet.design.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib动态代理
 * @author dell
 */
public class CglibDogEatProxy implements MethodInterceptor {

    /**
     * 需要代理的目标对象
     */
    private Object target;

    public Object createProxyObject(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("吃骨头之前得先买一个====>CGLIB");
        return method.invoke(target, objects);
    }
}
