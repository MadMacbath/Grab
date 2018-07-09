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
    private String nextPageUrl;
    private Page parent;
    private Parser parser;
    private Set<String> hrefs;
    private Page nextPage;
    private Set<JobInformation> jobInformationSet;
    private Set<Company> company;

    public Page(String url){
        this.url = url;

    }

    public Page getNextPage(){
        if (this.nextPageUrl != null && ! StringUtils.isEmpty(this.nextPageUrl))
            return parser.parsePage(this.nextPageUrl);
        return null;
    }
}





















