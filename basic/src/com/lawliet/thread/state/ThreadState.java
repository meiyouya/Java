package com.lawliet.thread.state;

/**
 * 测试线程生命周期状态
 * @author dell
 */
public class ThreadState implements Runnable{

    public synchronized void waitFotMoment() throws InterruptedException {
        /*
          使用wait(500)，使线程等待500ms
          其它线程如果在500ms之内想要唤醒线程，可以通过notify()或者notifyAll()方法唤醒
         */
        wait(500);
    }

    public synchronized void waitForever() throws InterruptedException {
        /*
        未传递时间，则永久等待，直至其它线程调用notify()或者notifyAll()方法唤醒
         */
        wait();
    }
    public synchronized void notifyNow() throws InterruptedException {
        /*
        使用notify()方法可以唤醒使用wait方法进入等待的线程
         */
        notify();
    }

    @Override
    public void run() {
        System.out.println("线程运行中");
        try {
            waitForever();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
