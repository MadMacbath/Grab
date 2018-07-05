package com.macbeth.algorithm.pattern.createpattern.builderpattern.impl;

import lombok.ToString;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:10:50
 **/
@ToString
public class Coke extends ColdDrink {
    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "coke";
    }
}
