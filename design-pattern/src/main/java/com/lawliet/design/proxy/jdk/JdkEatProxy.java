package com.lawliet.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用JDK动态代理
 * @author dell
 */
public class JdkEatProxy implements InvocationHandler {

    /**
     * 需要代理的目标对象
     */
    private Object target;

    /**
     * 创建目标对象的代理对象
     * @param target 需要代理的目标对象
     * @return 代理对象
     */
    public Object newProxy(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("不管你是谁，吃东西之前都得来找我要====>JDK");
        return method.invoke(target, args);
    }
}
