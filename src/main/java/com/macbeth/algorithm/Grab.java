package com.macbeth.algorithm;


import com.macbeth.algorithm.domain.Page;
import com.macbeth.algorithm.domain.impl.SimplePage;
import com.macbeth.algorithm.filedeal.FileDeal;
import com.macbeth.algorithm.filedeal.impl.SimpleFileDeal;
import com.macbeth.algorithm.olpath.Parser;
import com.macbeth.algorithm.olpath.impl.SimpleParser;

import java.io.IOException;

/**
 * author:macbeth
 * Date:2018/6/20
 * Time:11:40
 **/
public class Grab {
    public static void main(String[] args) throws IOException {
        Parser parser = new SimpleParser();
        FileDeal fileDeal = new SimpleFileDeal();
        Page page = SimplePage.getInstance(Constants.URL_PATH,parser,fileDeal);
        page.setRoot(page);
        page.ergodicSaveImg(page);
    }
}
