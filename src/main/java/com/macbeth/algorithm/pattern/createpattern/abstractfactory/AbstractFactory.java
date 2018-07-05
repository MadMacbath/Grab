package com.macbeth.algorithm.pattern.createpattern.abstractfactory;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:9:28
 **/
public abstract class AbstractFactory {
    public abstract Shape getShape(String shape);
    public abstract Color getColor(String color);
}
