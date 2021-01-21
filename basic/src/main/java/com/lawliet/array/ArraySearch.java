package com.lawliet.array;

/**
 * @author dell
 */
public class ArraySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
//        int index = Arrays.binarySearch(arr, 5);
        int index = binarySearch(arr, 0, arr.length, 3);
        System.out.println(index);
    }

    /**
     * 对已排序的数组进行二分查找
     * @param arr 已排序的数组
     * @param fromIndex 查找开始索引
     * @param toIndex 查找结束索引
     * @param key 要查找的元素
     * @return 要查找的元素所在的索引位置，返回-1代表没查到
     */
    private static int binarySearch(int[] arr, int fromIndex, int toIndex, int key) {
        int left = fromIndex;
        int right = toIndex;

        while (left <= right) {
            int midIndex = (left + right) >>> 1;
            int midVal = arr[midIndex];

            if (key < midVal) {
                // key在左边
                right = midIndex - 1;
            } else if (key > midVal) {
                // key在右边
                left = midIndex + 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }
}
