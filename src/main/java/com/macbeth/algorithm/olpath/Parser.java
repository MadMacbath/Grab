package com.macbeth.algorithm.olpath;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * author:macbeth
 * Date:2018/6/20
 * Time:11:47
 **/
public interface Parser {
    Set<String> parseImgPath();
    Set<String> parseHref();
    String parseTitle();
    void setContent(String content);
}
