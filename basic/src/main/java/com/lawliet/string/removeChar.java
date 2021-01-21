package com.lawliet.string;

public class removeChar {

    public static void main(String[] args) {

        String str = "test java";
        int index = 3;
        System.out.println(removeCharByIndex(str,index));
    }

    private static String removeCharByIndex(String str, int index) {
        return str.substring(0,index) + str.substring(index + 1);
    }

}
