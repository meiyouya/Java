package com.lawliet.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用ThreadPoolExecutor创建线程池
 * @author dell
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            MyRunnable runnable = new MyRunnable();
            executor.execute(runnable);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {}
        System.out.println("所有线程全部结束");
    }
}
