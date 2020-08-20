package com.lawliet.thread.sync;

/**
 * 同步代码块测试
 * @author dell
 */
public class SynchronizedCodeBlockTest {

    public void test() {
        synchronized (this) {
            System.out.println("同步代码块");
        }
    }
}
