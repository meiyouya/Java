package com.zql.jedis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JedisClient {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.174.188", 6379);
        jedis.auth("lawliet");
        System.out.println(jedis.ping());

        jedis.set("stringkey","stringvalue");
        System.out.println("redis存储的字符串：" + jedis.get("stringkey"));

        jedis.lpush("listkey","listvalue1");
        jedis.lpush("listkey","listvalue2");
        jedis.lpush("listkey","listvalue3");
        List<String> listkey = jedis.lrange("listkey", 0, 2);
        for (String s : listkey) {
            System.out.println(s);
        }

        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key);
        }
    }
}
