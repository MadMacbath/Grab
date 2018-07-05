package com.macbeth.algorithm.pattern.createpattern.builderpattern.impl;

import lombok.ToString;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:10:48
 **/
@ToString
public class VegBurger extends Burger {
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "vegBurger";
    }
}
