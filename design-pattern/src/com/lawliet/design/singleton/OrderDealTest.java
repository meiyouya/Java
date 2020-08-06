package com.lawliet.design.singleton;

import com.lawliet.design.strategy.OrderDealStrategy;

/**
 * @author lawliet.L
 */
public class OrderDealTest {

    public static void main(String[] args) {
        Order order = new Order();
        order.setId(1L);
        OrderDeal.getInstance().handle(OrderDealStrategy.DELIVERY, order);
    }
}
