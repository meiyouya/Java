package com.lawliet.thread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dell
 */
public class PrintDate {

    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    /**
     * 将SimpleDateFormat对象抽取出来，但是会出现线程安全问题
     * 输出的结果中会出现结果一样的现象
     */
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            // 每个线程内部都会创建一个SimpleDateFormat对象，很明显，当数量到达一定程度的时候会严重影响性能
            // 所以应该考虑把SimpleDateFormat对象抽取出来，多个线程一起用
            threadPool.submit(new Thread(() -> System.out.println(new PrintDate().date(finalI))));
        }
//        new Thread(() -> System.out.println(new PrintDate().date(10))).start();
//        new Thread(() -> System.out.println(new PrintDate().date(104707))).start();
        threadPool.shutdown();
    }

    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        return format.format(date);

        // 通过加锁可以解决线程的安全问题，但是在高并发下，性能会大幅下降
        /*String s;
        synchronized (PrintDate.class) {
            s = format.format(date);
        }
        return s;*/

        // 获取线程安全的format
        SimpleDateFormat format = ThreadSafeDateFormat.dateFormatThreadLocal.get();
        return format.format(date);
    }
}
