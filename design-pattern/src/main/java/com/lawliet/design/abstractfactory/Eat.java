package com.lawliet.design.abstractfactory;

import com.lawliet.design.abstractfactory.food.Food;
import com.lawliet.design.abstractfactory.tableware.TableWare;

import java.util.List;

/**
 * 厨房最终准备了哪些吃的
 * 有什么餐具可以选择
 * @author dell
 */
public class Eat {

    private List<Food> foodList;

    private List<TableWare> tableWareList;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List<TableWare> getTableWareList() {
        return tableWareList;
    }

    public void setTableWareList(List<TableWare> tableWareList) {
        this.tableWareList = tableWareList;
    }
}
