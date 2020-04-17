package com.zql.hutool.date;

import cn.hutool.core.date.DateUtil;

import java.util.Calendar;

public class DateUtilTest {

    public static void main(String[] args) {
        // 返回datetime类型
        System.out.println(DateUtil.date());    // yyyy-MM-dd HH:mm:ss 格式
        System.out.println(DateUtil.date(Calendar.getInstance()));// yyyy-MM-dd HH:mm:ss 格式
        System.out.println(DateUtil.date(System.currentTimeMillis()));// yyyy-MM-dd HH:mm:ss 格式

        // 返回string类型
        System.out.println(DateUtil.now());// yyyy-MM-dd HH:mm:ss 格式
        System.out.println(DateUtil.today());// yyyy-MM-dd 格式
    }
}
