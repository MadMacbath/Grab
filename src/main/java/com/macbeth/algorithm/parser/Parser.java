package com.macbeth.algorithm.parser;

import com.macbeth.algorithm.domain.Page;

import java.util.Set;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:41
 **/
public interface Parser {
    Page parse(String url);
    interface Request{
        String connect(String url);
    }
}
