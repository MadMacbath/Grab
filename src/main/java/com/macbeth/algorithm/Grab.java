package com.macbeth.algorithm;


import com.macbeth.algorithm.config.BeansConfig;
import com.macbeth.algorithm.domain.lagou.Company;
import com.macbeth.algorithm.service.CompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * author:macbeth
 * Date:2018/6/20
 * Time:11:40
 **/
public class Grab {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        CompanyService service= (CompanyService) context.getBean("companyService");
        Company company = service.getCompanyById(9l);
        System.out.println(company);
    }
}
