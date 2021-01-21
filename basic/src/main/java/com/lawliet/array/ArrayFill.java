package com.lawliet.array;

import java.util.Arrays;

public class ArrayFill {

    public static void main(String[] args) {
        int[] arr = new int[6];
        Arrays.fill(arr,10);
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr,3,6,5);
        System.out.println(Arrays.toString(arr));
    }
}
