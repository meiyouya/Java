package com.lawliet.string;

public class StringRegionMatch {

    public static void main(String[] args) {
        String first_str = "Welcome to Microsoft";
        String second_str = "I work with microsoft";
        System.out.println(first_str.regionMatches(11,second_str,12,9));
        System.out.println(first_str.regionMatches(true,11,second_str,12,9));
    }
}
