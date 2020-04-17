package com.zql.array;

import java.util.Arrays;

public class ArraySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        int index = Arrays.binarySearch(arr, 5);
        System.out.println(index);
    }
}
