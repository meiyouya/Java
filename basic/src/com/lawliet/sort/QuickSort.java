package com.lawliet.sort;

import java.util.Arrays;

/**
 * 快速排序又称划分交换排序，时间复杂度一般为O(nlogn)，最坏是O(n^2)
 * @author dell
 */
public class QuickSort {

    public static void sort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }

            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                //将指针继续移动
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        sort(arr, head, j);;
        sort(arr, i, tail);
    }

    public static void main(String[] args) {
        int[] arr = {2, 23, 5, 672, 21, 43};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
