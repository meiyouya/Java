package com.lawliet.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dell
 */
public class ArraysAsList {

    public static void main(String[] args) {
        // 如果直接在参数列表中传递参数，那么不会有什么问题
//        List<Integer> integers = Arrays.asList(1, 2, 3);
        // 如果先定义一个数组，那么，不要使用基本类型数组
        // 基本类型数组会作为一个整体，传递给asList方法，也就是说，asList实际上只会得到一个参数
        int[] arr = {1, 2, 4};
//        List<int[]> ints = Arrays.asList(arr);
//        System.out.println(ints.get(0));    // 这里会输出arr数组的地址值
//        System.out.println(ints.get(1));    // 这里就会抛出ArrayIndexOutOfBoundsException异常

        // Arrays.asList()方法，返回的是Arrays的一个内部静态类，这个内部静态类只实现了部分List的方法，如size，get，set，replace等
        // 像add，remove，clear这些方法是没有实现的，所以使用的话会抛出异常
//        integers.add(5);    // 抛出UnsupportedOperationException异常
//        Integer[] arr = {1, 2, 4};
        List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}
