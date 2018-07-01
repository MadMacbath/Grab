package com.macbeth.algorithm.domain.impl;

import com.macbeth.algorithm.domain.Page;
import com.macbeth.algorithm.filedeal.FileDeal;
import com.macbeth.algorithm.olpath.Parser;
import lombok.Data;

import java.util.Set;

/***
 * @author : macbeth
 * @date   : 2018/7/1 19:39
 * @mail   : madmacbeth@163.com
 */
@Data
public class SimplePage implements Page {
    private String title;
    private String url;
    private String content;
    private Set<String> imgUrls;
    private Set<String> hrefUrls;
    private Parser parser;
    private FileDeal fileDeal;

    public SimplePage(String url,Parser parser, FileDeal fileDeal){
        this.parser = parser;
        this.fileDeal = fileDeal;
        this.content = this.parser.getContent();
        this.hrefUrls = this.parser.parseHref();
        this.imgUrls = this.parser.parseImgPath();
        this.title = this.parser.parseTitle();
    }
    @Override
    public void saveImgs() {
        fileDeal.saveFile(this.imgUrls,"");
    }
}
