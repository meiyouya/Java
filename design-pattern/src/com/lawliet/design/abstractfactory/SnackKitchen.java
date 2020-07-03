package com.lawliet.design.abstractfactory;

import com.lawliet.design.abstractfactory.food.Food;
import com.lawliet.design.abstractfactory.food.FoodFactory;
import com.lawliet.design.abstractfactory.tableware.TableWare;
import com.lawliet.design.abstractfactory.tableware.TableWareFactory;

import java.util.List;

/**
 * 快餐店的厨房
 * @author dell
 */
public class SnackKitchen implements KitchenFactory{

    @Override
    public FoodFactory getFoodFactory() {
        return new FoodFactory();
    }

    @Override
    public TableWareFactory getTableWareFactory() {
        return new TableWareFactory();
    }

    @Override
    public void eat(Eat eat) {
        List<Food> foodList = eat.getFoodList();
        List<TableWare> tableWareList = eat.getTableWareList();
        if (null != foodList) {
            for (Food food : foodList) {
                System.out.println("吃的有：" + food.getName());
            }
        }
        if (null != tableWareList) {
            for (TableWare tableWare : tableWareList) {
                System.out.println("餐具有：" + tableWare.action());
            }
        }
    }
}
