package com.lawliet.thread.pool;

import java.util.Date;

/**
 * 自定义一个runnable
 * @author dell
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始时间：" + new Date());
        process();
        System.out.println(Thread.currentThread().getName() + "结束时间：" + new Date());
    }

    /**
     * 模拟每个线程处理5秒钟
     */
    private void process() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
