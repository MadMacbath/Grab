package com.macbeth.algorithm.parser;

import com.macbeth.algorithm.domain.Page;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:41
 **/
public interface Parser {
    Page parsePage(String url);
    void parseInformation(Page page);
}
