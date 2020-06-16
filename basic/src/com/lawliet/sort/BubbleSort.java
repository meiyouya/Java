package com.lawliet.sort;

import java.util.Arrays;

/**
 * 冒泡排序的逻辑较为简单
 * @author dell
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 23, 34, 1, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
