package com.lawliet.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @author lawliet.L
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        ToUpperRecursiveAction toUpperRecursiveAction = new ToUpperRecursiveAction("sndknakdhqwihdqjkwndjkqwnkqwd");
        // 将任务提交到线程池中
        commonPool.execute(toUpperRecursiveAction);
        // 触发任务执行
        Void join = toUpperRecursiveAction.join();
        System.out.println(join);

        SumArrayRecursiveTask sumArrayRecursiveTask = new SumArrayRecursiveTask(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        // 提交有返回值的任务到线程池
        Integer result = commonPool.invoke(sumArrayRecursiveTask);
        System.out.println(result);

        // 使用execute和submit方法可以提交无返回值的任务，需要手动调用join方法触发任务执行
        // 使用invoke方法提供有返回值的任务提交，无须手动调用join，如果有多个任务且需要保证任务顺序，则使用invokeAll方法
    }
}
