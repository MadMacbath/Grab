package com.macbeth.algorithm.pattern.createpattern.builderpattern.impl;

import com.macbeth.algorithm.pattern.createpattern.builderpattern.Item;
import com.macbeth.algorithm.pattern.createpattern.builderpattern.Packing;
import lombok.ToString;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:10:46
 **/
@ToString
public class Burger implements Item {
    @Override
    public String name() {
        return "burger";
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public float price() {
        return 1.3f;
    }
}
