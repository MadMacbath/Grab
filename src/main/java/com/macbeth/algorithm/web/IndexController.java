package com.macbeth.algorithm.web;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * author:macbeth
 * Date:2018/7/16
 * Time:16:50
 **/
@Controller
@RequestMapping(value = "test")
public class IndexController {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    @ResponseBody
    public Object index(){
        Map<String,String> map = Maps.newHashMap();
        map.put("name","macbeth");
        map.put("age","25");
        return map;
    }
}
