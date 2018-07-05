package com.macbeth.algorithm.pattern.createpattern.builderpattern.impl;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:10:58
 **/
public class MealBuilder {
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
