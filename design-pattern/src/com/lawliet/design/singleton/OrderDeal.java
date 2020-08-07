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

    private OrderDealStrategy strategy;

    public OrderDeal strategy(OrderDealStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    /**
     * 处理订单
     * @param order 要处理的订单
     */
    public void handle(Order order) {
        this.handle(order, false);
    }

    /**
     * 处理订单
     * @param order 要处理的订单
     * @param cache 是否要缓存本次的处理策略，默认false
     */
    public void handle(Order order, boolean cache) {
        this.strategy.handle(order);
        if (!cache) {
            this.strategy = null;
        }
    }

}
