package com.lawliet.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁测试
 * @author dell
 */
public class ReentrantLockTest {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("线程已被加锁");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
                System.out.println("线程已解锁");
            }
        });
        t.start();
    }
}
