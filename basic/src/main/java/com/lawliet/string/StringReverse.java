package com.lawliet.string;

public class StringReverse {

    public static void main(String[] args) {
        String str = "123456789";
        StringBuffer reverse = new StringBuffer(str).reverse();
        System.out.println(reverse);
    }
}
