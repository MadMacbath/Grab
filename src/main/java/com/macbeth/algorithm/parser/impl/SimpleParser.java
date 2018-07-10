package com.macbeth.algorithm.parser.impl;

import com.google.common.collect.Sets;
import com.macbeth.algorithm.DocumentPlus;
import com.macbeth.algorithm.domain.Page;
import com.macbeth.algorithm.domain.lagou.Company;
import com.macbeth.algorithm.domain.lagou.JobInformation;
import com.macbeth.algorithm.parser.Parser;
import com.macbeth.algorithm.utils.StringUtils;
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
    public Page parsePage(String url) {
        Set<String> sets = Sets.newHashSet();
        Page page = new Page(url);
        page.setUrl(url);
        page.setParser(this);
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
                String nextUrl = element.attr("href");
                if (! nextUrl.contains("javascript")){
                    page.setNextPageUrl(nextUrl);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }

    @Override
    public void parseInformation(Page page) {
        Set<String> sets = page.getHrefs();
        if (sets != null && sets.size() > 0) return;
        for (String href : sets){
            if (href.contains("jobs")){
                JobInformation jobInformation = this.parseJobInformation(href);
                page.getJobInformationSet().add(jobInformation);
            }
            if (href.contains("gongsi")){
                Company company = this.parseCompany(href);
                page.getCompany().add(company);
            }
        }
    }

    private Company parseCompany(String href) {
        Company company = new Company();
        try {
            DocumentPlus doc = (DocumentPlus) Jsoup.connect(href).get();

            String text = doc.getTextOfFirstElement(".top_info .hovertips");
            company.setName(text);

            text = doc.getTextOfFirstElement(".top_info .company_word");
            company.setDescription(text);

            Elements elements = doc.select(".item_container .number").next("span");
            text = doc.getTextOfFirstElement(elements);
            company.setScale(text);

            text = doc.getTextOfFirstElement(".li_title_text,.ellipsis");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private JobInformation parseJobInformation(String href) {
        return null;
    }
}















