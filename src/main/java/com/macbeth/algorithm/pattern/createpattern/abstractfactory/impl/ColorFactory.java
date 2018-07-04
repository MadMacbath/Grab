package com.macbeth.algorithm.pattern.createpattern.abstractfactory.impl;

import com.macbeth.algorithm.pattern.createpattern.abstractfactory.AbstractFactory;
import com.macbeth.algorithm.pattern.createpattern.abstractfactory.Color;
import com.macbeth.algorithm.pattern.createpattern.abstractfactory.Shape;

/**
 * author:macbeth
 * Date:2018/7/4
 * Time:17:58
 **/
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null)
            return null;
        if (color.equalsIgnoreCase("RED"))
            return new Red();
        else if (color.equalsIgnoreCase("BLUE"))
            return new Blue();
        else if (color.equalsIgnoreCase("GREEN"))
            return new Green();
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
