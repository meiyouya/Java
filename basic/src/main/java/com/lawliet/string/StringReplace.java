package com.lawliet.string;

public class StringReplace {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(str.replace("ll","L"));
        System.out.println(str.replaceFirst("l","L"));
        System.out.println(str.replaceAll("ll","L"));
    }
}
