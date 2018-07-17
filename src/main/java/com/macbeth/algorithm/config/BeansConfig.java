package com.macbeth.algorithm.config;

import com.macbeth.algorithm.mapper.CompanyMapper;
import com.macbeth.algorithm.parser.Parser;
import com.macbeth.algorithm.parser.Tester;
import com.macbeth.algorithm.parser.impl.SimpleParser;
import com.macbeth.algorithm.parser.impl.TesterOne;
import com.macbeth.algorithm.parser.impl.TesterThree;
import com.macbeth.algorithm.parser.impl.TesterTwo;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;

/**
 * author:macbeth
 * Date:2018/7/12
 * Time:16:48
 **/
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = "com.macbeth.algorithm")
public class BeansConfig {
}




































