package com.zql.gc;

/**
 * 新生代GC
 * @author lawliet-zhang
 */
public class MinorGC {

    private static final int _1MB = 1024 * 1024;

    /**
     * 启动时设置VM options：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * 堆内存限制在20MB，新生代分配10M，eden占80%，即8M，from survivor和to survivor各占1MB
     * 运行下面的方式时，在分配allocation4时，新生代内存不够了，所以会进行一次MinorGC
     * 但是每个对象都大于survivor的内存，所以allocation1、allocation2、allocation3都会被直接放进老年代
     * @param args
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
//        allocation1 = new byte[2 * _1MB];
//        allocation2 = new byte[2 * _1MB];
//        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
