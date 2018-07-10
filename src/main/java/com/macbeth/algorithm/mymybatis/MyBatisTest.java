package com.macbeth.algorithm.mymybatis;

import com.google.common.collect.Lists;
import com.macbeth.algorithm.domain.lagou.Company;
import com.macbeth.algorithm.mapper.CompanyMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * author:macbeth
 * Date:2018/7/10
 * Time:12:00
 **/
public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("MyBatis.xml"));
        SqlSession session = factory.openSession();
        CompanyMapper mapper = session.getMapper(CompanyMapper.class);
            Company company = new Company();
            company.setScale("-100");
            company.setName("test");
            company.setLocation("成都");
//            company.setDescription("desc");
        mapper.saveCompany(company);
        session.commit();
        session.close();
    }
}























