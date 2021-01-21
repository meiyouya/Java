package com.lawliet.thread.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 定义一个给数组求和的任务
 * RecursiveTask适用于有返回值的任务
 * @author lawliet.L
 */
public class SumArrayRecursiveTask extends RecursiveTask<Integer> {

    /**
     * 存储要求和的数组元素
     */
    private int[] arr;

    /**
     * 定义拆分任务的阈值
     */
    private static final int THRESHOLD = 10;

    public SumArrayRecursiveTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (arr.length > THRESHOLD) {
            // 拆分任务
            return ForkJoinTask.invokeAll(splitTasks()).stream()
                    // 使用join方法触发子任务的执行，并将结果转换为int
                    .mapToInt(ForkJoinTask::join)
                    // 对结果进行求和
                    .sum();
        } else {
            // 处理任务
            return process(arr);
        }
    }

    /**
     * 拆分子任务
     * @return Collection<SumArrayRecursiveTask>
     */
    private Collection<SumArrayRecursiveTask> splitTasks() {
        ArrayList<SumArrayRecursiveTask> subTasks = new ArrayList<>();
        int middleIndex = arr.length / 2;
        subTasks.add(new SumArrayRecursiveTask(Arrays.copyOfRange(arr, 0, middleIndex)));
        subTasks.add(new SumArrayRecursiveTask(Arrays.copyOfRange(arr, middleIndex, arr.length)));
        return subTasks;
    }

    /**
     * 处理求和逻辑
     * @param arr 要处理的数组
     * @return 和
     */
    private Integer process(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
