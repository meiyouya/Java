package com.lawliet.collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dell
 */
public class CollectionsTest {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        // 第二个参数指定要旋转的个数
        // 正数时，将最后的指定个数的数据保持顺序不变放到最前面去
        Collections.rotate(nums, 2);
        System.out.println(nums);
        // 负数时，将最前面的指定个数的数据保持顺序不变放到最后去
        Collections.rotate(nums, -2);
        System.out.println(nums);
        // 统计元素出现的次数
        System.out.println(Collections.frequency(nums, 2));
        // 用新的值替换指定元素
        boolean result = Collections.replaceAll(nums, 2, 22);
        System.out.println(nums);
    }
}
