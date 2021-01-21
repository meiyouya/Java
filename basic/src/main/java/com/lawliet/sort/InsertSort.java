package com.lawliet.sort;

import java.util.Arrays;

/**
 * 插入排序适合在数据量较少时使用，时间复杂度O(n^2)
 * @author dell
 */
public class InsertSort {

    public static void sort(int[] arr) {
        int j;
        int tmpValue;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                tmpValue = arr[i];
                for (j = i - 1; j >= 0 && arr[j] > tmpValue ; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = tmpValue;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 23, 5, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
