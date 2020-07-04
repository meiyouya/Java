package com.lawliet.design.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 测试单例模式
 * @author dell
 */
public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        Semaphore semaphore = new Semaphore(20);
        for (int i = 0; i < 1000; i++) {
            // 测试1000个线程，20并发创建单例对象
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
//                    DoubleCheckLockLazySingleton instance = DoubleCheckLockLazySingleton.getInstance();   // 获取到的都是同一对象
//                    EnumSingleton instance = EnumSingleton.INSTANCE;  // 获取到的都是同一对象
//                    HungrySingleton instance = HungrySingleton.getInstance(); // 获取到的都是同一对象
//                    LazySingleton instance = LazySingleton.getInstance();   // 会出现1-3个不同的对象
//                    SafeLazySingleton instance = SafeLazySingleton.getInstance();   // 获取到的都是同一对象
                    StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();   // 获取到的都是同一对象
                    System.out.println(instance);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();

    }
}
