package com.lawliet.design.singleton;

import com.lawliet.design.strategy.OrderDealStrategy;

/**
 * @author lawliet.L
 */
public class OrderDealTest {

    public static void main(String[] args) {
        Order order = new Order();
        order.setId(1L);
        OrderDeal.getInstance().strategy(OrderDealStrategy.DELIVERY).handle(order, true);
        OrderDeal.getInstance().handle(order);
        OrderDeal.getInstance().strategy(OrderDealStrategy.PAY).handle(order);
        OrderDeal.getInstance().handle(order);
    }
}
