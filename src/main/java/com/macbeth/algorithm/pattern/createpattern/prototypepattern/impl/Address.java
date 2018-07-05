package com.macbeth.algorithm.pattern.createpattern.prototypepattern.impl;

import lombok.Data;
import lombok.ToString;

import java.beans.Transient;
import java.io.Serializable;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:15:52
 **/
@Data
@ToString
public class Address implements Serializable{
    private static final long serialVersionUID = 2208830271007049058L;
    private long id;
    private String username;
}
