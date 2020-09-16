package com.lawliet.sort;

import java.util.Arrays;

/**
 * 快速排序又称划分交换排序，时间复杂度平均为O(nlogn)，最坏是O(n^2)
 * @author dell
 */
public class QuickSort {

    public static void sort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex || arr == null || arr.length <= 1) {
            return;
        }
        int pivotIndex = (startIndex + endIndex) / 2;
        int left = startIndex, right = endIndex, pivotValue = arr[pivotIndex];
        // 在左指针和右指针重合之前都需要继续排序
        while (left <= right) {
            while (arr[left] < pivotValue) {
                // 左边的值小于基准值，无须操作元素，left指针右移一位
                ++left;
            }
            while (arr[right] > pivotValue) {
                // 右边的值大于基准值，无须操作元素，right指针左移一位
                --right;
            }

            // 这里元素的移动使用的是指针交换法，也可以使用挖坑法移动元素，二者效率基本一样
            if (left < right) {
                // left > right时代表已经排序完毕

                // 若果左元素大于基准值且右元素小于基准值，交换left和right对应的值
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
                //将指针继续移动
                ++left;
                --right;
            } else if (left == right) {
                // 重合时右移left或者左移right可跳出循环
                ++left;
            }
        }
        // 一轮走完，更改基准值，继续下一轮
        // 此时right指针已经移动到left的左边，所以新的endIndex的值就是right的值
        sort(arr, startIndex, right);;
        // 此时left指针已经移动到right的右边，所以新的startIndex的值就是left的值
        sort(arr, left, endIndex);
    }

    public static void main(String[] args) {
        int[] arr = {2, 23, 5, 672, 21, 43};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
