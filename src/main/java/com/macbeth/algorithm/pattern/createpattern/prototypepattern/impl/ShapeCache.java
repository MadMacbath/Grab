package com.macbeth.algorithm.pattern.createpattern.prototypepattern.impl;

import com.macbeth.algorithm.pattern.createpattern.prototypepattern.Shape;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Hashtable;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:14:02
 **/
public class ShapeCache {
    private static Hashtable<String,Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeId){
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);
        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);
        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setId(1l);
        user.setAge(25);
        user.setGender(true);
        user.setUsername("macbeth");
        user.setPrent("parent");
        Address address = new Address();
        address.setId(2l);
        address.setUsername("chenwei");
        user.setAddress(address);
        Path path = Paths.get("e://test.txt");
//        write(user,path);
        read(user,path);
        System.out.println(user.getPrent());
        System.out.println(user);
    }

    public static void read(User user, Path path) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path));
        user = (User) ois.readObject();
    }

    public static void write(User user, Path path) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));
        oos.writeObject(user);
    }
}


























