package com.macbeth.algorithm.parser;

import com.macbeth.algorithm.domain.Page;
import com.macbeth.algorithm.domain.lagou.Company;
import com.macbeth.algorithm.domain.lagou.JobInformation;

import java.io.IOException;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:41
 **/

public interface Parser {
    Page parsePage(String url);
    String parseNextPageUrl(String currentUrl)throws IOException;
    Company parseCompany(String url);
    JobInformation parseJobInformation(String url);
}
