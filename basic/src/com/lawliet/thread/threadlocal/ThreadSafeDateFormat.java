package com.lawliet.thread.threadlocal;

import java.text.SimpleDateFormat;

/**
 * 创建一个类，把
 */
public class ThreadSafeDateFormat {

    /**
     * 在ThreadLocal中创建一份SimpleDateFormat
     */
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
}
