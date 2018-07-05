package com.macbeth.algorithm.pattern.createpattern.prototypepattern.impl;

import com.macbeth.algorithm.pattern.createpattern.prototypepattern.Shape;
import lombok.ToString;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:14:00
 **/
public class Circle extends Shape {
    public Circle(){
        type = "circle";
    }
    @Override
    public void draw() {
        System.out.println("circle draw");
    }
}
