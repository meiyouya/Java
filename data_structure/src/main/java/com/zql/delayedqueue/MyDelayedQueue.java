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
            DelayedItem delayedItem = delayQueue.poll();
            if (delayedItem != null) {
                // 能获取到，说明元素已过期，执行想要的操作，这里以过期就删除为例
                // 也可在此处执行其他业务逻辑
                itemMap.remove(delayedItem.getKey());
            }
        }
    }
}
