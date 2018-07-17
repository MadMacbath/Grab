package com.macbeth.algorithm.parser.impl;

import com.macbeth.algorithm.parser.Encoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * author:macbeth
 * Date:2018/7/16
 * Time:13:59
 **/
@Aspect
@Component
public class EncoreableIntroduce {
    @DeclareParents(value = "com.macbeth.algorithm.parser.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
