package com.macbeth.algorithm.service;

import com.macbeth.algorithm.domain.lagou.Company;

/**
 * author:macbeth
 * Date:2018/7/18
 * Time:10:04
 **/
public interface CompanyService {
    Company getCompanyById(long id);
}
