package com.macbeth.algorithm;


import com.macbeth.algorithm.config.BeansConfig;
import com.macbeth.algorithm.parser.Encoreable;
import com.macbeth.algorithm.parser.Parser;
import com.macbeth.algorithm.parser.Performance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * author:macbeth
 * Date:2018/6/20
 * Time:11:40
 **/
public class Grab {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        Performance performance = (Performance) context.getBean("performance");
        performance.perform("macbeth");
        Encoreable encoreable = (Encoreable) performance;
        encoreable.performEncore();
    }
}
