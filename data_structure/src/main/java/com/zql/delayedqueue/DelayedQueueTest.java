package com.zql.delayedqueue;

/**
 * @author dell
 */
public class DelayedQueueTest {

    public static void main(String[] args) {
        MyDelayedQueue delayedQueue = new MyDelayedQueue();
        delayedQueue.put("a", "aValue", 5);
        delayedQueue.put("b", "bValue", 10);
        delayedQueue.put("c", "cValue", 15);
        while (true) {
            String a = delayedQueue.get("a");
            String b = delayedQueue.get("b");
            String c = delayedQueue.get("c");
            System.out.println("a: " + a + " b: " + b + " c: " + c);

            if (null == a && null == b && null == c) {
                // 所有元素都过期则退出循环
                break;
            }
        }
        delayedQueue.shutdown();
    }
}
