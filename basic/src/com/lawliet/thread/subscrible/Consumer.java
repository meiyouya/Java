package com.lawliet.thread.subscrible;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 消费者
 * @author dell
 */
public class Consumer {

    private LinkedBlockingQueue<Integer> queue;

    public Consumer(LinkedBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void start() {
        new Thread(() -> {
            while (true) {
                try {
                    Integer data = queue.take();
                    System.out.println("消费到数据：" + data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
