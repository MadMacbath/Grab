package com.macbeth.algorithm.pattern.createpattern.abstractfactory.impl;

import com.macbeth.algorithm.pattern.createpattern.abstractfactory.Shape;

/**
 * author:macbeth
 * Date:2018/7/4
 * Time:17:33
 **/
public class Rectangle implements Shape {
    @Override
    public void drow() {
        System.out.println("rectangle drow");
    }
}
