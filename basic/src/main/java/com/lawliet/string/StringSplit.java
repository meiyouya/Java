package com.lawliet.string;

public class StringSplit {

    public static void main(String[] args) {
        String str = "www.baidu.com";
        String splitRegex = "\\.";
        String[] temp = str.split(splitRegex);
        for (String s : temp) {
            System.out.println(s);
        }
    }
}
