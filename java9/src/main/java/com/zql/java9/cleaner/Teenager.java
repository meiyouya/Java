package com.zql.java9.cleaner;

public class Teenager {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("exit");
        // 没有使用try-with-resource不会调用close方法
        // 所以只能手动去调gc方法，但是这个方法并不保证close方法一定会执行
        System.gc();
    }
}
