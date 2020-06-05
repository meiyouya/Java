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

    private QueueListener queueListener;

    public RingBlockingQueue() {
        super();
    }

    public RingBlockingQueue(QueueListener queueListener) {
        super();
        this.queueListener = queueListener;
    }

    public void setQueueListener(QueueListener queueListener) {
        this.queueListener = queueListener;
    }

    @Override
    public boolean add(E e) {
        final ReentrantLock putLock = this.putLock;
        try {
            putLock.lockInterruptibly();
            super.add(e);

            if (queueListener != null) {
                queueListener.afterAdd(e);
            }
            return true;
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            return false;
        } finally {
            putLock.unlock();
        }
    }

    /**
     * 返回当前指向的元素，并把指针指向下一个元素
     *
     * @return 当前元素
     */
    @Override
    public E next() {
        final ReentrantLock putLock = this.putLock;
        try {
            putLock.lockInterruptibly();
            return super.next();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            return null;
        } finally {
            putLock.unlock();
        }
    }

    /**
     * 返回当前指向的元素，并把指针指向上一个元素
     *
     * @return 当前元素
     */
    @Override
    public E prev() {
        final ReentrantLock putLock = this.putLock;
        try {
            putLock.lockInterruptibly();
            return super.prev();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            return null;
        } finally {
            putLock.unlock();
        }
    }

    /**
     * 删除环形队列中的指定元素
     *
     * @param e 要删除的元素
     * @return 删除结果
     */
    @Override
    public boolean remove(E e) {
        final ReentrantLock putLock = this.putLock;
        try {
            putLock.lockInterruptibly();

            if (queueListener != null) {
                queueListener.afterRemove(e);
            }
            return super.remove(e);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            return false;
        } finally {
            putLock.unlock();
        }
    }

    interface QueueListener<E> {
        void afterAdd(E e);
        void afterRemove(E e);
    }
}
