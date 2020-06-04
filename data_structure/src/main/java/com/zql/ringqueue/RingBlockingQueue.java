package com.zql.ringqueue;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞环形队列，解决多线程下的安全问题
 * @author lawliet.L
 */
public class RingBlockingQueue<E> extends RingQueue<E> {
    /**
     * 使用jdk提供的可重入锁进行操作的加锁
     */
    protected final ReentrantLock putLock = new ReentrantLock();

    interface QueueListener<E> {

    }
}
