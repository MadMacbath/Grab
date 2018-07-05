package com.macbeth.algorithm;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * author:macbeth
 * Date:2018/6/20
 * Time:11:40
 **/
public class Grab {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://www.lagou.com/jobs/4817377.html").get();
        Elements elements = document.select("div.job-name span.name");
        if (elements != null && elements.size() > 0){
            Element element = elements.get(0);
            System.out.println(element.text());
        }
    }
}
