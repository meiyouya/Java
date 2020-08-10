package com.zql.hutool.util;

import cn.hutool.core.util.ReUtil;

/**
 * @author lawliet.L
 */
public class ReUtilTest {

    public static void main(String[] args) {
        String content = "ZZZaaabbbccc中文1234";
        String s = ReUtil.extractMulti("(\\w)aa(\\w)", content, "$1-$2");
        System.out.println(s);
    }
}
