package com.lawliet.bloom;

/**
 * @author lawliet.L
 * 判断某个数字是否在某个数字集合中
 * 判断存在的时候存在一定的误报率
 * 三个特点如下：
 * 1. 判断结果为不存在，就一定不存在
 * 2. 判断结果为存在，只是大概率存在
 * 3. 其数组中的数据无法清除，所以每次使用必须重新初始化
 * size越大，hash次数越多，误报率就越小，同样的，CPU和内存的消耗也就越大
 * 所以布隆过滤更适合做不存在校验而不是存在校验
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
    public void add(String data) {
        int first = hashFirst(data);
        int second = hashSecond(data);
        int third = hashThird(data);

        array[first % size] = 1;
        array[second % size] = 1;
        array[third % size] = 1;
    }

    /**
     * 检查data是否存在
     * @param data
     * @return
     */
    public boolean check(String data) {
        int first = hashFirst(data);
        int second = hashSecond(data);
        int third = hashThird(data);
        return array[first % size] != 0 && array[second % size] != 0 && array[third % size] != 0;
    }

    /**
     * 第一次hash
     * @param data
     * @return hash的结果
     */
    private int hashFirst(String data) {
        int hash = 0;
        for (int i = 0; i < data.length(); i++) {
            hash = 33 * hash + data.charAt(i);
        }
        return Math.abs(hash);
    }

    /**
     * 第二次hash
     * @param data
     * @return hash的结果
     */
    private int hashSecond(String data) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < data.length(); i++) {
            hash = (hash ^ data.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);
    }

    /**
     * 第三次hash
     * @param data
     * @return hash的结果
     */
    private int hashThird(String data) {
        int hash = 0;
        for (int i = 0; i < data.length(); i++) {
            hash += data.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash);
    }

    public static void main(String[] args) {
        /*long begin1 = System.currentTimeMillis();
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
        System.out.println(end2 - begin2);*/

    }
}
