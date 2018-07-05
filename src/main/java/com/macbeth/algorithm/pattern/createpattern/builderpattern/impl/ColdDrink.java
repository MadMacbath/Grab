package com.macbeth.algorithm.pattern.createpattern.builderpattern.impl;

import com.macbeth.algorithm.pattern.createpattern.builderpattern.Item;
import com.macbeth.algorithm.pattern.createpattern.builderpattern.Packing;
import lombok.ToString;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:10:47
 **/
@ToString
public class ColdDrink implements Item {
    @Override
    public String name() {
        return "cold drink";
    }

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public float price() {
        return 0.8f;
    }
}
