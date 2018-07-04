package com.macbeth.algorithm.pattern.createpattern.abstractfactory.impl;

import com.macbeth.algorithm.pattern.createpattern.abstractfactory.AbstractFactory;

/**
 * author:macbeth
 * Date:2018/7/4
 * Time:18:00
 **/
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if (choice == null)
            return null;
        if (choice.equalsIgnoreCase("SHAPE"))
            return new ShapeFactory();
        else if (choice.equalsIgnoreCase("COLOR"))
            return new ColorFactory();
        return null;
    }
}
