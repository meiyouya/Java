package com.lawliet.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dell
 */
public class PrintAbc {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static int count = 1;
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    if (count > 9) {
                        break;
                    }
                    if (count % 3 == 1) {
                        System.out.println("A");
                        count++;
                        condition.signalAll();
                    } else {
                        try {
                            condition.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        });
        Thread threadB = new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    if (count > 9) {
                        break;
                    }
                    if (count % 3 == 2) {
                        System.out.println("B");
                        count++;
                        condition.signalAll();
                    } else {
                        try {
                            condition.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        });
        Thread threadC = new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    if (count > 9) {
                        break;
                    }
                    if (count % 3 == 0) {
                        System.out.println("C");
                        count++;
                        condition.signalAll();
                    } else {
                        try {
                            condition.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
