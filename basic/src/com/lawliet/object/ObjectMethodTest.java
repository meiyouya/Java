package com.lawliet.object;

/**
 * 测试Object里的11个方法
 * @author dell
 */
public class ObjectMethodTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneObject cloneObject = new CloneObject();
        System.out.println(cloneObject);
        System.out.println(cloneObject.hashCode());
        Object clone = cloneObject.clone();
        System.out.println(clone);
        System.out.println(clone.hashCode());
        System.out.println(cloneObject.equals(clone));
    }
}
