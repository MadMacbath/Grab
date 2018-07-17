package com.macbeth.algorithm.mymybatis;

import com.google.common.collect.Lists;
import com.macbeth.algorithm.domain.lagou.Company;
import com.macbeth.algorithm.domain.lagou.JobInformation;
import com.macbeth.algorithm.mapper.CompanyMapper;
import com.macbeth.algorithm.mapper.JobInformationMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.Date;
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
        JobInformationMapper mapper = session.getMapper(JobInformationMapper.class);
        CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
        Company company = companyMapper.selectCompany(9l);

//        JobInformation information = new JobInformation();
//        information.setJobName("test company id");
//        information.setCompany(company);
//        information.setDescription("description");
//        information.setJobAdvantage("advantage");
//        information.setJobRequest("request");
//        information.setJobRequestSummary("request summary");
//        information.setPublishTime(new Date());
//        mapper.saveJobInformation(information);
        JobInformation jobInformation = mapper.selectInformation();
        System.out.println(jobInformation);

//        session.commit();
        session.close();
    }
}























