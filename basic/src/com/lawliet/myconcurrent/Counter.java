package com.lawliet.myconcurrent;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 计数器类
 * @author lawliet.L
 */
public class Counter {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {

        /*
          测试普通计数器和基于cas的线程安全计数器
         */
        Counter cas = new Counter();
        ArrayList<Thread> threads = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    cas.count();
                    cas.safeCount();
                }
            });
            threads.add(t);
        }
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicInteger);
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 使用cas实现的线程安全的计数器
     */
    private void safeCount() {
        for (;;) {
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    /**
     * 普通计数器，非线程安全
     */
    private void count() {
        i++;
    }
}
