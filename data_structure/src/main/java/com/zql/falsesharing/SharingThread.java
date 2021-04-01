package com.zql.falsesharing;

import sun.misc.Contended;

/**
 * 测试共享的线程
 */
public class SharingThread implements Runnable{

    public final static long ITERATIONS = 500L * 1000L * 100L;
    private static ValuePadding[] longs;
    private int arrayIndex = 0;

    public SharingThread(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    @Override
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = 0L;
        }
    }

    public static void testSharing(int num) throws InterruptedException {
        Thread[] threads = new Thread[num];
        longs = new ValuePadding[num];
        // 初始化ValuePadding
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new ValuePadding();
        }
        // 初始化线程组中的线程
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new SharingThread(i));
        }
        // 运行线程组内所有线程
        for (Thread thread : threads) {
            thread.start();
        }
        // 让主线程等待所有子线程执行完毕
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static final class ValuePadding {
        // value前面和后面各定义了7个变量去填充，看似无用，但是当并发数量上去的时候，
        // 多个线程访问value的值的时候，都从缓存行中直接获取，无须从主存中获取
//        protected long p1, p2, p3, p4, p5, p6, p7;
        // 不过只有Java8之前需要使用前后填充的方式来解决伪共享的问题
        // Java8新增了如下注解，可以使用在类或者字段上来处理伪共享问题
        @Contended
        protected volatile long value = 0L;
//        protected long p9, p10, p11, p12, p13, p14, p15;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.gc();
            long start = System.currentTimeMillis();
            testSharing(i);
            System.out.println("线程组[" + i + "] 执行耗时：" + (System.currentTimeMillis() - start));
        }
        // 伪共享情况下执行结果
        // 线程组[0] 执行耗时：0
        // 线程组[1] 执行耗时：360
        // 线程组[2] 执行耗时：1940
        // 线程组[3] 执行耗时：2197
        // 线程组[4] 执行耗时：1987
        // 线程组[5] 执行耗时：3434
        // 线程组[6] 执行耗时：4003
        // 线程组[7] 执行耗时：3567
        // 线程组[8] 执行耗时：3300
        // 线程组[9] 执行耗时：2501
        // 使用前后填充的执行结果：
        // 线程组[0] 执行耗时：0
        // 线程组[1] 执行耗时：358
        // 线程组[2] 执行耗时：344
        // 线程组[3] 执行耗时：424
        // 线程组[4] 执行耗时：400
        // 线程组[5] 执行耗时：385
        // 线程组[6] 执行耗时：451
        // 线程组[7] 执行耗时：576
        // 线程组[8] 执行耗时：608
        // 线程组[9] 执行耗时：679
        // 使用Java8新注解的执行结果和使用前后填充的结果基本是一样的
        // 如果使用sun.misc.Contended，要记得在启动时增加如下JVM参数：-XX:-RestrictContended
    }
}
