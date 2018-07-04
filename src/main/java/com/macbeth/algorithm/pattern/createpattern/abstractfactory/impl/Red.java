package com.macbeth.algorithm.pattern.createpattern.abstractfactory.impl;

import com.macbeth.algorithm.pattern.createpattern.abstractfactory.Color;

/**
 * author:macbeth
 * Date:2018/7/4
 * Time:17:52
 **/
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("red fill");
    }
}
