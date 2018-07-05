package com.macbeth.algorithm.pattern.createpattern.builderpattern.impl;

import lombok.ToString;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:10:49
 **/
@ToString
public class ChickenBurger extends Burger {
    @Override
    public float price() {
        return 55.0f;
    }

    @Override
    public String name() {
        return "chicken burger";
    }
}
