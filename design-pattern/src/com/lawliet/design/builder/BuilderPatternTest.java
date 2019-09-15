package com.lawliet.design.builder;

/**
 * @author dell
 */
public class BuilderPatternTest {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        vegMeal.showItems();
        System.out.println(vegMeal.getCost());
    }
}
