package com.zql.delayedqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 需要放入延时队列的元素
 * 必须实现delayed接口
 * @author dell
 */
public class DelayedItem implements Delayed {

    /**
     * 需要放入延时队列的元素
     */
    private String key;

    /**
     * 过期时间，单位秒
     */
    private long expireTime;

    /**
     * 加入队列的时间
     */
    private long joinTime;

    public DelayedItem(String key, long expireTime) {
        this.key = key;
        this.expireTime = expireTime;
        this.joinTime = System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        // 计算剩余的过期时间，如果大于0说明未过期
        // 剩余过期时间 = 过期时间 - 从加入队列到当前过去的时间
        return expireTime - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - joinTime);
    }

    @Override
    public int compareTo(Delayed o) {
        // 过期时间长的放在队列尾部，过期时间短的放在队列首部
        return Long.compare(this.getDelay(TimeUnit.MICROSECONDS), o.getDelay(TimeUnit.MICROSECONDS));
    }

    public String getKey() {
        return key;
    }
}
