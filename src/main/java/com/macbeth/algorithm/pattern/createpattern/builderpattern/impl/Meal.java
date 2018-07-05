package com.macbeth.algorithm.pattern.createpattern.builderpattern.impl;

import com.google.common.collect.Lists;
import com.macbeth.algorithm.pattern.createpattern.builderpattern.Item;

import java.util.List;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:10:52
 **/
public class Meal {
    private List<Item> items = Lists.newArrayList();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        return items.stream().map(Item::price).reduce(Float::sum).get();
    }

    public void showItems(){
        items.stream().forEach(System.out::println);
    }
}























