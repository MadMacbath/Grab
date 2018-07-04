package com.macbeth.algorithm.parser;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:13:51
 **/
@Data
public class Dom {
    private String TagName;
    private String value;
    private Map<String,String> properties = Maps.newHashMap();
    private List<Dom> children;

    public Dom(){}

    public Dom(String tagName, String value, Map<String, String> properties) {
        TagName = tagName;
        this.value = value;
        this.properties = properties;
    }

    public String getPropertyByPropertyKey(String key){
        return this.properties.get(key);
    }
}
