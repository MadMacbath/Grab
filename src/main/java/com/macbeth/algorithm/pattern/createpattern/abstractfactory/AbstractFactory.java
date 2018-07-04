package com.macbeth.algorithm.pattern.createpattern.abstractfactory;

/**
 * author:macbeth
 * Date:2018/7/4
 * Time:17:54
 **/
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
