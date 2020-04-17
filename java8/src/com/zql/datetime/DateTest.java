package com.zql.datetime;

import java.time.*;

public class DateTest {
    public static void main(String[] args) {

        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);
        LocalDate nowLocalDate = now.toLocalDate();
        System.out.println("当前日期：" + nowLocalDate);
        int year = now.getYear();
        System.out.println("当前年：" + year);
        Month month = now.getMonth();
        System.out.println("当前月份：" + month);

        //获得指定时间
        LocalDateTime localDateTime = now.withDayOfMonth(3);    // 设置日期为3号
        System.out.println(localDateTime);
        // 还有很多其他的withXxx方法设置其他信息

        // 获得指定日期
        LocalDate of = LocalDate.of(2019, 3, 1);
        System.out.println(of);

        // 获得指定时间
        LocalTime localTime = LocalTime.of(13, 23);// 有三个重载方法，分别是（时，分）、（时，分，秒 ）、（时，分，秒，纳秒）
        System.out.println(localTime);

        // 解析日期和时间
        LocalDate parse = LocalDate.parse("2019-11-11");    // 间隔必须是 -
        System.out.println(parse.getYear());
        LocalTime parse1 = LocalTime.parse("13:23:11"); // 间隔必须是 :
        System.out.println(parse1.getHour());

        // 带时区的时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);  // 输出：2019-02-19T21:12:53.939+08:00[Asia/Shanghai]
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println(currentZone);    // 当前时区
    }
}
