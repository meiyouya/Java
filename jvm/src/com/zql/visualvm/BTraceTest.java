package com.zql.visualvm;

import cn.hutool.core.util.RandomUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BTrace是visualVM的一个插件
 * 可以在不停止目标程序的情况下加入原本不存在的代码
 * @author lawliet.L
 */
public class BTraceTest {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        BTraceTest bTrace = new BTraceTest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            reader.readLine();
            int a = RandomUtil.randomInt(100);
            int b = RandomUtil.randomInt(100);
        }
    }
}
