package com.lawliet.thread.state;

/**
 * @author dell
 */
public class ThreadStateTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadState threadState = new ThreadState();
        Thread thread = new Thread(threadState);
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(100);
        System.out.println(thread.getState());
        Thread.sleep(1000);
        System.out.println(thread.getState());
        threadState.notifyNow();
        System.out.println(thread.getState());
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }
}
