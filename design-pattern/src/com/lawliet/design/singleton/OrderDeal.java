package com.lawliet.design.singleton;

import com.lawliet.design.strategy.OrderDealStrategy;

/**
 * 订单处理类枚举
 * @author lawliet.L
 */
public enum OrderDeal {

    INSTANCE;

    public static OrderDeal getInstance() {
        return INSTANCE;
    }

    public void handle(OrderDealStrategy strategy, Order order) {
        strategy.handle(order);
    }

}
