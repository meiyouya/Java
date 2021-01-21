package com.lawliet.string;

public class StringCompare {

    public static void main(String[] args) {
        /*String str = "Hello World";
        String anotherStr = "hello world";
        Object objStr = str;

        System.out.println(str.compareTo(anotherStr));
        System.out.println(str.compareToIgnoreCase(anotherStr));
        System.out.println(str.compareTo(objStr.toString()));*/

        System.out.println(compareString("abc1", "abc"));
    }

    private static boolean compareString(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        if (aLength != bLength) {
            return false;
        }
        int len = Math.max(aLength, bLength);
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
