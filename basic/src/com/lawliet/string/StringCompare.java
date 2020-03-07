package com.zql.string;

public class StringCompare {

    public static void main(String[] args) {
        String str = "Hello World";
        String anotherStr = "hello world";
        Object objStr = str;

        System.out.println(str.compareTo(anotherStr));
        System.out.println(str.compareToIgnoreCase(anotherStr));
        System.out.println(str.compareTo(objStr.toString()));
    }
}
