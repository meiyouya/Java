package com.lawliet.design.abstractfactory.food;

/**
 * 食物工厂，用于创建做饭所需要的食物
 * @author dell
 */
public class FoodFactory {

    /**
     * 从食物工厂中拿出一个苹果
     * @return 苹果对象
     */
    public Apple getApple() {
        return new Apple();
    }

    /**
     * 从食物工厂中拿出一块肉
     * @return 肉对象
     */
    public Meat getMeat() {
        return new Meat();
    }
}
