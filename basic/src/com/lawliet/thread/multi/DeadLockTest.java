package com.lawliet.thread.multi;

/**
 * 死锁
 * @author dell
 */
public class DeadLockTest {

    // 定义两个资源供线程访问
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread().getName() + "---->已经获取到资源A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "---->正在等待获取资源B");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread().getName() + "---->已经获取到资源B");
                }
            }
        }, "线程A").start();
        new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread().getName() + "---->已经获取到资源A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "---->正在等待获取资源B");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread().getName() + "---->已经获取到资源B");
                }
            }
        }, "线程B").start();

        // 这种方式会造成循环等待，从而造成死锁
        /*new Thread(() -> {
            synchronized (resourceB) {
                System.out.println(Thread.currentThread().getName() + "---->已经获取到资源B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "---->正在等待获取资源A");
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread().getName() + "---->已经获取到资源A");
                }
            }
        }, "线程B").start();*/
    }
}
