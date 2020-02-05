package com.lawliet.bloom;

/**
 * @author lawliet.L
 * 判断某个数字是否在某个数字集合汇总
 */
public class BloomFilter {

    /**
     * 数组的长度
     */
    private int size;

    /**
     * 数组
     */
    private int[] array;

    /**
     * 提供初始化数组的构造方法
     * @param size
     */
    public BloomFilter(int size) {
        this.size = size;
        array = new int[size];
    }

    /**
     * 向数组中写入数据
     * @param key
     */
    public void add(String key) {

    }

    /**
     * 第一次hash
     * @param key
     * @return hash的结果
     */
    private int hashFirst(String key) {
        int result = 0;
        for (int i = 0; i < key.length(); i++) {
            result = 33 * result * key.charAt(i);
        }
        return Math.abs(result);
    }

    public static void main(String[] args) {
        long begin1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.print(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println();
        System.out.println(end1 - begin1);
        long begin2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; ++i) {
            System.out.print(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println();
        System.out.println(end2 - begin2);
    }
}
