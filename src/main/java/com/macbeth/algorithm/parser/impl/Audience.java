package com.macbeth.algorithm.parser.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * author:macbeth
 * Date:2018/7/16
 * Time:10:15
 **/
@Aspect
@Component
public class Audience {
    @Pointcut("execution(* com.macbeth.algorithm.parser.Performance.perform(..)) && bean(performance) && args(name)")
    public void performance(String name){}

    @Before("performance(name)")
    public void beforePerformace(String name){
        System.out.println("before performance " + name);
    }

    @After("performance(name)")
    public void afterPerformace(String name){
        System.out.println("after performance " + name);
    }

    @Around("performance(name)")
    public void watchPerformance(ProceedingJoinPoint pp, String name) throws Throwable {
        System.out.println("around before " + name);
        pp.proceed();
        System.out.println("around after " + name);
    }

}



















