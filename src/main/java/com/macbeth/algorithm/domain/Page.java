package com.macbeth.algorithm.domain;

import com.google.common.collect.Sets;
import com.macbeth.algorithm.domain.lagou.Company;
import com.macbeth.algorithm.domain.lagou.JobInformation;
import com.macbeth.algorithm.parser.Parser;
import com.macbeth.algorithm.utils.StringUtils;
import lombok.Data;

import java.io.IOException;
import java.util.Set;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:47
 **/
@Data
public class Page {
    private String url;
    private Parser parser;
    private Set<String> hrefs = Sets.newHashSet();

    private String nextPageUrl;
    private Page nextPage;
    private Set<JobInformation> jobInformations = Sets.newHashSet();
    private Set<Company> companies = Sets.newHashSet();

    public Page(String url){
        this.url = url;

    }

    public String getNextPageUrl(){
        if (StringUtils.isEmpty(this.nextPageUrl)) {
            try {
                this.nextPageUrl = this.parser.parseNextPageUrl(this.url);
            }catch (IOException e){
                return null;
            }
        }
        return nextPageUrl;
    }

    public Page getNextPage(){
        if (this.nextPage == null){
            this.nextPage = this.parser.parsePage(this.getNextPageUrl());
        }
        return this.nextPage;
    }

    public Set<JobInformation> getJobInformations(){
        if (this.jobInformations.size() <= 0){
            for (String url :this.getHrefs()){
                JobInformation jobInformation = this.parser.parseJobInformation(url);
                if (jobInformation == null) continue;
                this.jobInformations.add(jobInformation);
            }
        }
        return this.jobInformations;
    }

    public Set<Company> getCompanies(){
        if (this.companies.size() <= 0) {
            for (String url : this.getHrefs()){
                Company company = this.parser.parseCompany(url);
                if (company == null) continue;
                this.companies.add(company);
            }
        }
        return this.companies;
    }
}





















