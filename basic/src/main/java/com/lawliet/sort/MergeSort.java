package com.lawliet.sort;

import java.util.Arrays;

/**
 * 归并排序采用分治法，是建立在归并操作上的有效排序算法
 * @author dell
 */
public class MergeSort {

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            // left < right时代表数据还可以被拆分
            int middle = (left + right) / 2;
            // 左边数组继续拆分
            sort(arr, left, middle);
            // 右边数据继续拆分
            sort(arr, middle + 1, right);
            // 拆分完毕后，进行数组合并
            merge(arr, left, middle, right);
        }
    }

    /**
     * 合并数组
     * @param arr 数组
     * @param left 左
     * @param middle 中
     * @param right 右
     */
    private static void merge(int[] arr, int left, int middle, int right) {
        // 申请一个存放合并数组的空间，其大小等于被合并的2个数组之和即可
        int[] temp = new int[right - left + 1];

        int i  = left;
        int j = middle + 1;
        int k = 0;

        // 排序操作
        while (i <= middle && j <= right) {
            // 较小的先放入合并后的数组
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 剩余元素写入合并后的数组
        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            arr[l + left] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 23, 54, 6, 675, 12, 56};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
