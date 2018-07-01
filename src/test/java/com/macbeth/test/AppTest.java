package com.macbeth.test;

import com.macbeth.myfunction.MyFunction;
import lombok.Data;

/***
 * @author : macbeth
 * @date   : 2018/7/1 18:32
 * @mail   : madmacbeth@163.com
 */
public class AppTest {
    public void ergodic(MyFunction function){
    }

    public void myTest(){

    }
    public static void main(String[] args) {
        AppTest test = new AppTest();

    }
}
@Data
class Test{
    private static String testName = "chenwei";
    private String username = "macbeth";

    public static String getTestName(){
        return testName;
    }

    public void sayHello(){
        System.out.println("chenwei");
    }
}
