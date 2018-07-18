package com.macbeth.algorithm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

/**
 * author:macbeth
 * Date:2018/7/12
 * Time:16:48
 **/
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = "com.macbeth.algorithm")
@ImportResource(value = {"classpath*:spring-mybatis.xml"})
public class BeansConfig {
}




































