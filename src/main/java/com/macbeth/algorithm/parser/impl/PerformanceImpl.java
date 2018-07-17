package com.macbeth.algorithm.parser.impl;

import com.macbeth.algorithm.parser.Performance;
import org.springframework.stereotype.Service;

/**
 * author:macbeth
 * Date:2018/7/16
 * Time:10:50
 **/
@Service("performance")
public class PerformanceImpl implements Performance {
    @Override
    public void perform(String name) {
        System.out.println("performance " + name);
    }
}
