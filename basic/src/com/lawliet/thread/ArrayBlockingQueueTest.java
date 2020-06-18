package com.lawliet.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue 是由数组支持的有界阻塞队列。位于 java.util.concurrent 包下。
 * @author dell
 */
public class ArrayBlockingQueueTest {

    private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {

        // 向队列中添加数据的线程
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                queue.add((i + 1));
            }
        });
        thread1.start();
        try {
            // 调用join方法后，主线程会等待thread1执行完毕才继续向下执行，可以理解为主线程在此处sleep到thread1执行完毕
            thread1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 在队列已满的情况下，向队列中继续添加元素，此处应该永远无法加入任何元素，除非队列中的元素减少，有闲置的空间出来
        Thread thread2 = new Thread(() -> {
            while (true) {
                boolean flag = true;
                if (!queue.offer((6))) {
                    flag = false;
                    System.out.println("队列已满，入队6失败");
                }
                if (flag) {
                    break;
                }
            }
        });
        thread2.start();

        // 移除队列中的元素，使线程2可以插入新的数据
        Thread thread3 = new Thread(() -> {
            Integer element;
            System.out.println("开始出队：");
            while ((element = queue.poll()) != null) {
                System.out.println(element + "\t");
            }
        });
        thread3.start();
    }
}
