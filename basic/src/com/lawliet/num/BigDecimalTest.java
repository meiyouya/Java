package com.lawliet.num;

import java.math.BigDecimal;

/**
 * @author dell
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);      // 输出0.1000000000000000055511151231257827021181583404541015625
        BigDecimal b = BigDecimal.valueOf(0.1);
        System.out.println(b);      // 输出0.1
    }
}
