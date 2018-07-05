package com.macbeth.algorithm.pattern.createpattern.abstractfactory;

import com.macbeth.algorithm.pattern.createpattern.abstractfactory.impl.Circle;
import com.macbeth.algorithm.pattern.createpattern.abstractfactory.impl.Rectangle;
import com.macbeth.algorithm.pattern.createpattern.abstractfactory.impl.Square;

/**
 * author:macbeth
 * Date:2018/7/4
 * Time:17:34
 **/
// 静态工厂
public class ShapeFactory {
    public static Shape createShape(String shapeType){
        if (shapeType == null)
            return null;
        if (shapeType.equalsIgnoreCase("CIRCLE"))
            return new Circle();
        else if (shapeType.equalsIgnoreCase("RECTANGLE"))
            return new Rectangle();
        else if (shapeType.equalsIgnoreCase("SQUARE"))
            return new Square();
        return null;
    }

    public static void main(String[] args) {
        Shape shape = createShape("rectangle");
        shape.drow();
    }
}
