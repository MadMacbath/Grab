package com.macbeth.algorithm.pattern.createpattern.prototypepattern;

import lombok.Data;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:13:51
 **/
@Data
public abstract class Shape implements Cloneable{
    private String id;
    protected String type;
    public abstract void draw();

    @Override
    public Object clone() {
        Object clone = null;
        try{
            clone = super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}


















