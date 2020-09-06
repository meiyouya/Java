package com.zql.gc;

/**
 * 测试gc是否使用了引用计数
 * 在运行时添加VM options：-XX:+PrintGCDetails就可以看到gc日志
 * 测试证明，当前版本的gc没有使用引用计数
 * 查阅资料后确认，主流的Java虚拟机均没有使用引用计数法，Python使用的是引用计数法
 * @author lawliet.L
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}
