package com.macbeth.algorithm.pattern.createpattern.prototypepattern.impl;

import com.macbeth.algorithm.pattern.createpattern.prototypepattern.Shape;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:13:54
 **/
public class Rectangle extends Shape{
    public Rectangle(){
        type = "rectangle";
    }
    @Override
    public void draw(){
        System.out.println("rectangle draw");
    }
}
