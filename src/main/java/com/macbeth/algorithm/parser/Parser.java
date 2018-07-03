package com.macbeth.algorithm.parser;

import java.util.Set;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:41
 **/
public interface Parser {
    String getContent(String url);
    Set<String> parseHrefs();
    Set<String> paseImgs();

}
