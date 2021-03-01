package com.lawliet.design.abstractfactory;

import com.lawliet.design.abstractfactory.food.FoodFactory;
import com.lawliet.design.abstractfactory.tableware.TableWareFactory;

/**
 * 当有多个工厂并且这些工厂具有相同的特性是
 * 可以抽取一个抽象工厂，即创建工厂的工厂
 * 这就是抽象工厂模式
 * @author dell
 */
public interface KitchenFactory {

    /**
     * 获取食物工厂
     * @return 食物工厂对象
     */
    FoodFactory getFoodFactory();

    /**
     * 获取餐具工厂
     * @return 餐具工厂对象
     */
    TableWareFactory getTableWareFactory();

    /**
     * 这个厨房有哪些吃的
     */
    void eat(Eat eat);
}
