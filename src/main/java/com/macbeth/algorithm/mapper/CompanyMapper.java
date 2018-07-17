package com.macbeth.algorithm.mapper;

import com.macbeth.algorithm.domain.lagou.Company;

import java.util.List;

/**
 * author:macbeth
 * Date:2018/7/10
 * Time:13:49
 **/
public interface CompanyMapper {
    Company selectCompany(Long id);
    void saveCompany(Company company);
    List<Company> selectCompanies();
    void saveCompanies(List<Company> list);
}
