package com.lawliet.thread.forkjoin;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * 定义一个将字母转换为大写的任务
 * RecursiveAction适用于没有返回值的任务
 * @author lawliet.L
 */
@Slf4j
public class ToUpperRecursiveAction extends RecursiveAction {

    /**
     * 要转换的单词
     */
    private String word;

    /**
     * 拆分任务的预知
     */
    private static final int THRESHOLD = 4;

    public ToUpperRecursiveAction(String word) {
        this.word = word;
    }

    @Override
    protected void compute() {
        if (word.length() > THRESHOLD) {
            // 单词的长度超过阈值，进行任务拆分
            ForkJoinTask.invokeAll(splitTask());
        } else {
            // 进行任务的处理
            process(word);
        }
    }

    /**
     * 拆分子任务
     * @return ArrayList<ToUpperRecursiveAction>
     */
    private List<ToUpperRecursiveAction> splitTask() {
        ArrayList<ToUpperRecursiveAction> subTasks = new ArrayList<>();
        int middleIndex = word.length() / 2;
        // 每次均拆分为一半
        String left = word.substring(0, middleIndex);
        String right = word.substring(middleIndex);
        subTasks.add(new ToUpperRecursiveAction(left));
        subTasks.add(new ToUpperRecursiveAction(right));
        return subTasks;
    }

    /**
     * 抽取出的任务处理的逻辑
     * @param word 要处理的单词
     */
    private void process(String word) {
        String s = word.toUpperCase();
        log.info("线程：{}处理结果：{}", Thread.currentThread().getName(), s);
    }
}
