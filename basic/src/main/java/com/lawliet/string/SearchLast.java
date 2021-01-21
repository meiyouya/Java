package com.lawliet.string;

public class SearchLast {

    public static void main(String[] args) {
        String strOriginal = "Hello World,Hello You";
        int lastIndex = strOriginal.lastIndexOf("12");
        if (lastIndex == -1) {
            System.out.println("没找到");
        }else {
            System.out.println("ll最后出现的位置：" + lastIndex);
        }
    }
}
