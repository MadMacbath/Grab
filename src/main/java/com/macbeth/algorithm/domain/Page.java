package com.macbeth.algorithm.domain;

import com.google.common.collect.Sets;
import com.macbeth.algorithm.domain.lagou.Company;
import com.macbeth.algorithm.domain.lagou.JobInformation;
import com.macbeth.algorithm.parser.Parser;
import com.macbeth.algorithm.utils.StringUtils;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:47
 **/
@Data
public class Page {
    private String url;
    private Page parent;
    private Parser parser;
    private String content;
    private Set<String> imgs;
    private Set<String> hrefs;
    private Set<Page> children;

    public static Page getInstance(String url, Parser parser){
        Page page = new Page();
        page.url = url;
        page.parser = parser;
        page.content = parser.getContent(page.url);
        if (StringUtils.isEmpty(page.content)) return null;
        page.hrefs = page.parser.parseHrefs();
        page.imgs = page.parser.paseImgs();
        return page;
    }

    public Set<Page> getChildren(){
        if (this.children != null || this.children.size() > 0){
            return this.children;
        }
        Set<Page> sets = Sets.newHashSet();
        for (String href : this.hrefs){
            Page page = getInstance(href,this.parser);
            if (page == null) continue;
            page.setParent(this);
            sets.add(page);
        }
        this.setChildren(sets);
        return sets;
    }

    public Company getCompany(){
        Company company = new Company();
        return company;
    }

    public JobInformation getJobInformation(){
        JobInformation jobInformation = new JobInformation();
        Pattern pattern = Pattern.compile("(?<=<span class=\"name\">)\\w(?=</span>)");
        Matcher matcher = pattern.matcher(this.content);
        if (matcher.find()){
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            String jobName = this.content.substring(startIndex,endIndex);
            jobInformation.setJobName(jobName);
        }

        pattern = Pattern.compile("");

        return jobInformation;
    }

    public void ergodicExecute(Page page, List<Company> companies, List<JobInformation> jobInformations){
        if (page == null) return;
        companies.add(page.getCompany());
        jobInformations.add(page.getJobInformation());
        Set<Page> children = page.getChildren();
        if (children == null) return;
        for (Page child : children){
            ergodicExecute(child,companies,jobInformations);
        }
    }

}
