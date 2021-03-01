package com.lawliet.design.wrapper;

/**
 * 女孩装饰器测试
 * @author dell
 */
public class WrapperTest {

    public static void main(String[] args) {
        Girl girl = new GoldHair(new HappyGirl(new Girl("女孩")));
        System.out.println(girl.getDesc());
    }
}
