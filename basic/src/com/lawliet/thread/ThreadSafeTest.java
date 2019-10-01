package com.lawliet.thread;

public class ThreadSafeTest implements Runnable {

    int num = 10;

    @Override
    public void run() {
        while (true) {
            synchronized ("") {
                if (num > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // 没有使用同步，输出num时，有很大几率num会小于0，使用同步之后就不会了
                    System.out.println("还剩" + num--);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadSafeTest thread = new ThreadSafeTest();
        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        Thread t3 = new Thread(thread);
        Thread t4 = new Thread(thread);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
