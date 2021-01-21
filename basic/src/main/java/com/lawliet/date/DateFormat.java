package com.lawliet.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    public static void main(String[] args) {
        Date date = new Date();
        String regex = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(regex);
        System.out.println(simpleDateFormat.format(date));
    }
}
