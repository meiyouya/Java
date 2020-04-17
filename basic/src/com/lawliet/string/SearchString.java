package com.zql.string;

public class SearchString {

    public static void main(String[] args) {
        String strOriginal = "Baidu Google Sougou Souhu";
        int index = strOriginal.indexOf("oo");
        if (index == -1) {
            System.out.println("没找到");
        } else {
            System.out.println("索引：" + index);
        }
    }
}
