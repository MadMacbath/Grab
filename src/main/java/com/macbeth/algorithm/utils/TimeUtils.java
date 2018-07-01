package com.macbeth.algorithm.utils;

/**
 * author:macbeth
 * Date:2018/6/29
 * Time:17:30
 **/
public class TimeUtils {
    public static void endTime(long startTime,String methodName,String targetHref,boolean isCatch){
        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        if (result / 1000 > 1)
            System.out.println(isCatch ? "catch:::" : "" +methodName + "----" + targetHref + " : " + result);
    }
}
