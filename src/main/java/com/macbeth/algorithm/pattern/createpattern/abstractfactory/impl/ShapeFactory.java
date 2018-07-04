package com.macbeth.algorithm.pattern.createpattern.abstractfactory.impl;

import com.macbeth.algorithm.pattern.createpattern.abstractfactory.AbstractFactory;
import com.macbeth.algorithm.pattern.createpattern.abstractfactory.Color;
import com.macbeth.algorithm.pattern.createpattern.abstractfactory.Shape;

/**
 * author:macbeth
 * Date:2018/7/4
 * Time:17:55
 **/
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (shape == null)
            return null;
        if (shape.equalsIgnoreCase("CIRCLE"))
            return new Circle();
        else if (shape.equalsIgnoreCase("RECTANGLE"))
            return new Rectangle();
        else if (shape.equalsIgnoreCase("SQUARE"))
            return new Square();
        return null;
    }
}
















