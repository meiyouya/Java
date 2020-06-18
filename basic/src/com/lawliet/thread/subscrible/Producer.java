package com.lawliet.thread.subscrible;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author dell
 */
public class Producer{

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        Consumer consumer = new Consumer(queue);
        // 启动消费者
        consumer.start();

        while (true) {
            Random random = new Random();
            int i = random.nextInt();
            queue.put(i);
            Thread.sleep(1000);
        }
    }
}
