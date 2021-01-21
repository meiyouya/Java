package com.lawliet.enums;

/**
 * @author dell
 */
public class EnumTest {

    public static void main(String[] args) {
        System.out.println(OrderStatus.COMPLETED.name());
        System.out.println(OrderStatus.COMPLETED);
        System.out.println(OrderStatus.COMPLETED.name().getClass());
        System.out.println(OrderStatus.COMPLETED.getClass());

        System.out.println(OrderStatus.PAYED.isPay());
    }
}
