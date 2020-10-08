package com.zql.compiler;

import java.util.List;

/**
 * 编译期的泛型擦除测试
 * @author lawliet.L
 */
public class GenericTypeTest {

    public static void generic(List<String> list) {
        System.out.println(list);
    }

    // 下面的两个方法编译都会报错
    // 虽然list的泛型不一样，但是在编译时会擦除泛型，使用强制类型转换导致无法重载
//    public static void generic(List<Integer> list) {
//        System.out.println(list);
//    }

//    public static int generic(List<Integer> list) {
//        System.out.println(list);
//        return 1;
//    }
}
