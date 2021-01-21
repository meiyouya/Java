package com.lawliet.boxing;

public class BoxingTest {

    public static void main(String[] args) {
        /*long start = System.currentTimeMillis();
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);    // 运行多次，平均时间6000ms*/


        long start = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);    // 运行多次，平均时间610ms
    }
}
