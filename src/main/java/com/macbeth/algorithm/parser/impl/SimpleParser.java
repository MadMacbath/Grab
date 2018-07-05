package com.macbeth.algorithm.parser.impl;

import com.google.common.collect.Sets;
import com.macbeth.algorithm.domain.Page;
import com.macbeth.algorithm.parser.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Set;

/**
 * author:macbeth
 * Date:2018/7/5
 * Time:17:23
 **/
public class SimpleParser implements Parser {
    @Override
    public Page parse(String url) {
        Set<String> sets = Sets.newHashSet();
        Page page = new Page(url);
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("href");
            if (elements != null && elements.size() > 0){
                for (int index = 0; index < elements.size(); index ++){
                    String href = elements.get(index).text();
                    if (! ((href.contains("jobs") || href.contains("gongsi")) && href.endsWith("html"))) continue;
                    sets.add(href);
                }
            }
            page.setHrefs(sets);
            Element element = document.select(".page_no").last();
            if (element != null) {
                element.attr("href");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }
}















