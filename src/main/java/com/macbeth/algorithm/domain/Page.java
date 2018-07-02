package com.macbeth.algorithm.domain;

import java.io.IOException;
import java.util.Set;

/***
 * @author : macbeth
 * @date   : 2018/7/1 19:38
 * @mail   : madmacbeth@163.com
 */
public interface Page {
    void saveImgs();
    String getContent();
    String getBasePath();
    void setBasePath(String basePath);
    Page getParentPage();
    void setParentPage(Page parentPage);
    Set<Page> getChildren();
    void setChildren(Set<Page> children);
    Page getRoot();
    void setRoot(Page root);
    void ergodicSaveImg(Page page) throws IOException ;
    String getTitle();
    void SetTitle(String title);
}
