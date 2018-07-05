package com.macbeth.algorithm;

/**
 * author:macbeth
 * Date:2018/6/20
 * Time:14:08
 **/
public class Constants {
    // 抓取根目录
    public static String URL_PATH = "https://www.lagou.com/zhaopin/";//"https://www.jd.com";//"http://www.atguigu.com/";//"https://www.csdn.net";
    // 图片路径规则
    public static String IMG_PATH_PATTERN = "(?<=src=\")(\\w|\\/|-|\\d|\\.|:)*";
    // 超链接解析规则
    public static String HREF_PATH_PATTERN = "(?<=href=\")(\\w|\\/|\\.|-|\\d|:)*";
    // 文件存储位置
    public static String SAVE_FILE_PATH = "e:/grab";
    // 文件存储位置，二级目录
    public static String SAVE_FILE_SECOND_PATH = "LAGOU";
    // 图片格式
    public static String IMG_FORMAT = "JPG|PNG|GIF";

}
