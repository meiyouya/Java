package com.lawliet.design.abstractfactory;

import com.lawliet.design.abstractfactory.food.Apple;
import com.lawliet.design.abstractfactory.food.Food;
import com.lawliet.design.abstractfactory.food.FoodFactory;
import com.lawliet.design.abstractfactory.tableware.Bowl;
import com.lawliet.design.abstractfactory.tableware.TableWare;
import com.lawliet.design.abstractfactory.tableware.TableWareFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象工厂模式测试
 * @author dell
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        List<Food> foodList = new ArrayList<>();
        List<TableWare> tableWareList = new ArrayList<>();

        SnackKitchen snackKitchen = new SnackKitchen();
        // 获取快餐店的食物工厂
        FoodFactory foodFactory = snackKitchen.getFoodFactory();
        // 获取快餐店的餐具工厂
        TableWareFactory tableWareFactory = snackKitchen.getTableWareFactory();
        Apple apple = foodFactory.getApple();
        foodList.add(apple);
        Bowl bowl = tableWareFactory.getBowl();
        tableWareList.add(bowl);

        Eat eat = new Eat();
        eat.setFoodList(foodList);
        eat.setTableWareList(tableWareList);
        snackKitchen.eat(eat);
    }
}
