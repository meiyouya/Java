package com.zql.classload;

/**
 * 对类的主动引用会触发类的初始化而被动引用不会
 * 主动引用就是虚拟机规范严格规定的<em>有且只有</em>的五种形式
 * 被动引用是指除了那5种之外任何其它的引用类的方式
 * 这里演示一下什么是被动引用
 * @author lawliet.L
 */
public class ClassInitTest {

    public static void main(String[] args) {
        // 被动引用demo1
        // 子类调用父类的静态字段，不会触发子类的初始化
        // 因为静态字段只会触发该静态字段定义所在的类的初始化，所以这里只会初始化SuperClass
//        System.out.println(SubClass.value);

        // 被动引用demo2
        // 一般情况下，遇到new指令时一定会触发初始化的，但是如果使用的是数组定义来引用这个类，那么就不会触发初始化
        // 所以这里不会进行SuperClass的初始化，但是会触发一个名字叫[Lcom.zql.classload.SuperClass的类的初始化
        // 这个类是虚拟机自动生产的直接继承自java.lang.Object的类，有指定newarray触发其初始化
        // 这个类包含了数组的属性和方法，但是我们能直接使用的直接length属性和clone()方法
//        SuperClass[] superClasses = new SuperClass[10];

        // 被动引用demo3
        // 常量在编译阶段就会存入调用类的常量池中，所以并没有引用到定义常量的类
        // 因此不会调用类的初始化
        System.out.println(SuperClass.HELLO);
    }
}

class SuperClass {
    static {
        System.out.println("Super Class init!");
    }

    public static int value = 123;

    public static final String HELLO = "Hello World";
}


class SubClass extends SuperClass {
    static {
        System.out.println("Sub Class init!");
    }
}
