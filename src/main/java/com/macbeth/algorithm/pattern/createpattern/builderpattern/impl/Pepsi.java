package com.macbeth.algorithm.pattern.createpattern.builderpattern.impl;

import lombok.ToString;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:10:51
 **/
@ToString
public class Pepsi extends ColdDrink {
    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "pepsi";
    }
}
