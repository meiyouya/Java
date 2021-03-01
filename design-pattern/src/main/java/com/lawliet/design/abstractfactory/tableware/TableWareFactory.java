package com.lawliet.design.abstractfactory.tableware;

/**
 * 餐具工厂，用于创建吃饭所需要的餐具
 * @author dell
 */
public class TableWareFactory {

    /**
     * 从餐具工厂中拿出一个碗
     * @return 碗对象
     */
    public Bowl getBowl() {
        return new Bowl();
    }

    /**
     * 从餐具工厂中拿出一双筷子
     * @return 筷子对象
     */
    public Chopsticks getChopsticks() {
        return new Chopsticks();
    }
}
