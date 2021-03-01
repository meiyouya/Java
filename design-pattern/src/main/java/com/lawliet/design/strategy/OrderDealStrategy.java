package com.lawliet.design.strategy;

import com.lawliet.design.singleton.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lawliet.L
 */
@Slf4j
public enum OrderDealStrategy {

    PAY {
        @Override
        public void handle(Order order) {
            log.info("正在处理支付------{}", order);
        }
    },
    DELIVERY {
        @Override
        public void handle(Order order) {
            log.info("正在处理发货------{}", order);
        }
    },
    RECEIVED {
        @Override
        public void handle(Order order) {
            log.info("正在处理收货------{}", order);
        }
    };


    public abstract void handle(Order order);
}
