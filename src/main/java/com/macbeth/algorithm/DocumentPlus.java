package com.macbeth.algorithm;

import com.macbeth.algorithm.utils.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * author:macbeth
 * Date:2018/7/6
 * Time:10:00
 **/
public class DocumentPlus extends Document {

    public DocumentPlus(String baseUri) {
        super(baseUri);
    }

    public String getTextOfFirstElement(String cssQuery){
        Elements elements = this.select(cssQuery);
        if (elements.size() <= 0) return null;
        return StringUtils.trim(elements.get(0).text());
    }

    public String getTextOfFirstElement(Elements elements){
        if (elements.size() <= 0) return null;
        return StringUtils.trim(elements.get(0).text());
    }
}
