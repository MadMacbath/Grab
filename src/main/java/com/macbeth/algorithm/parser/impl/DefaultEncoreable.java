package com.macbeth.algorithm.parser.impl;

import com.macbeth.algorithm.parser.Encoreable;

/**
 * author:macbeth
 * Date:2018/7/16
 * Time:14:01
 **/
public class DefaultEncoreable implements Encoreable {
    @Override
    public void performEncore() {
        System.out.println("encoreable");
    }
}
