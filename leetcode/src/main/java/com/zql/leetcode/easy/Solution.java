package com.zql.leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static List<Integer> addToArrayForm(int[] A, int K) {
        String kStr = String.valueOf(K);
        StringBuilder num = new StringBuilder();
        int carry = 0;
        for (int i = A.length - 1, j = kStr.length() - 1; i >= 0 || j >= 0; i--,j--) {
            // r 一定大于等于0且小于等于18
            int iValue;
            if (i < 0) {
                iValue = 0;
            } else {
                iValue = A[i];
            }
            int kValue;
            if (j < 0) {
                kValue = 0;
            } else {
                kValue = Integer.parseInt(String.valueOf(kStr.charAt(j)));
            }
            int r = iValue + kValue + carry;
            num.append(",");
            if (r > 9) {
                carry = 1;
                num.append(r - 10);
            } else {
                carry = 0;
                num.append(r);
            }
        }
        if (carry == 1) {
            num.append(",").append(1);
        }
        StringBuilder reverse = num.reverse();
        String[] numStrArr = reverse.toString().split(",");
        return Arrays.stream(numStrArr).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] A = {1};
        int K = 33;
        System.out.println(addToArrayForm(A, K));
    }
}
