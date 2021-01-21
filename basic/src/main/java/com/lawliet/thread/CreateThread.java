package com.lawliet.thread;

/**
 * 创建线程测试
 * @author dell
 */
public class CreateThread {

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
//        Thread2 thread2 = new Thread2();    // 直接new通过实现Runnable接口的线程是无法启动的，因为Runnable接口中只定义了一个run方法
        Thread thread2 = new Thread(new Thread2());
        thread2.start();
    }
}

class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread1的任务正在执行");
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread2的任务正在执行");
    }
}
