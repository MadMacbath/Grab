package com.macbeth.algorithm.pattern.createpattern.prototypepattern.impl;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:14:49
 **/
@Data
@ToString
public class User extends Entity implements Serializable, Cloneable{
    private static final long serialVersionUID = -8300207654862486233L;
    private Long id;
    private String username;
    private boolean gender;
    private int age;
    private Address address;
}
















