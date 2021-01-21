package com.lawliet.enums;

/**
 * @author dell
 */

public enum OrderStatus {

    UN_PAY,
    PAYED,
    ORDER,
    DELIVERY,
    RECEIVED,
    COMPLETED;

    public boolean isPay() {
        return this == OrderStatus.PAYED;
    }
}
