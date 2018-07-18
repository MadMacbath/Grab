package com.macbeth.algorithm.service.impl;

import com.macbeth.algorithm.domain.lagou.Company;
import com.macbeth.algorithm.mapper.CompanyMapper;
import com.macbeth.algorithm.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author:macbeth
 * Date:2018/7/18
 * Time:10:05
 **/
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyMapper companyMapper;

    @Override
    public Company getCompanyById(long id) {
        return companyMapper.selectCompany(id);
    }
}
