package com.zql.delayedqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.DelayQueue;

/**
 * @author dell
 * 自定义延时队列
 * 以到时间自动删除缓存为例
 */
public class MyDelayedQueue implements Runnable{

    /**
     * 停止标识
     */
    private boolean stop = false;

    /**
     * 模拟缓存，非必须成员
     */
    private Map<String, String> itemMap = new HashMap<>();

    /**
     * 初始化延迟队列
     */
    private DelayQueue<DelayedItem> delayQueue = new DelayQueue<>();

    public MyDelayedQueue() {
        // 开启内部线程，检测是否过期
        new Thread(this).start();
    }

    public void put(String key, String value, long expireTime) {
        DelayedItem delayedItem = new DelayedItem(key, expireTime);

        delayQueue.add(delayedItem);

        // 将数据存入缓存
        itemMap.put(key, value);
    }

    /**
     * 获取缓存中的值
     * @param key
     * @return
     */
    public String get(String key) {
        return itemMap.get(key);
    }

    /**
     * 关闭延迟队列
     */
    public void shutdown() {
        this.stop = true;
    }
    @Override
    public void run() {
        while (!stop) {
            // poll方法会移除头部的元素并返回它，队列为空会返回null
            // 如果需要一定要获取到元素，可以使用take方法，队列为空时会一直阻塞
            // 如果不想移除，可以使用peek方法，该方法只会返回头部元素而不会删除
            // 获取元素时，如果有必要，也可以使用element方法，如果队列为空会抛出NoSuchElementException的异常
            // 同样的，如果在移除时有必要，可以使用remove方法，移除并返回队列头部的元素，如果队列为空会抛出NoSuchElementException的异常
            DelayedItem delayedItem = delayQueue.poll();
            if (delayedItem != null) {
                // 能获取到，说明元素已过期，执行想要的操作，这里以过期就删除为例
                // 也可在此处执行其他业务逻辑
                itemMap.remove(delayedItem.getKey());
            }
        }
    }
}
