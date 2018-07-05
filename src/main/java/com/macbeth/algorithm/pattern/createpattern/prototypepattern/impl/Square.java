package com.macbeth.algorithm.pattern.createpattern.prototypepattern.impl;

import com.macbeth.algorithm.pattern.createpattern.prototypepattern.Shape;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:13:59
 **/
public class Square extends Shape {
    public Square(){
        type = "square";
    }
    @Override
    public void draw() {
        System.out.println("square draw");
    }
}
