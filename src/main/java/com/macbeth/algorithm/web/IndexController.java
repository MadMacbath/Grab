package com.macbeth.algorithm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * @author : macbeth
 * @date   : 2018/7/16 20:32
 * @mail   : madmacbeth@163.com
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
