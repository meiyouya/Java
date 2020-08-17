package com.lawliet.thread.multi;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 多线程测试
 * @author dell
 */
public class MultiThreadTest {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 获取所有的线程，第一个参数代表是否获取同步的monitor，第二参数代表是否获取同步的synchronizer
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("线程id：" + threadInfo.getThreadId() + "====线程名称：" + threadInfo.getThreadName());
        }
    }
}
