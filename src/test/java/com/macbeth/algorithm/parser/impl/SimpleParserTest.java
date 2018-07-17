package com.macbeth.algorithm.parser.impl;

import com.macbeth.algorithm.config.BeansConfig;
import com.macbeth.algorithm.parser.Parser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BeansConfig.class})
@ActiveProfiles("dev")
public class SimpleParserTest {
    @Autowired
    @Qualifier(value = "simpleParser")
    private Parser parser;
    @Test
    public void test1() throws Exception {
        Assert.assertNotNull(parser);
        parser.tests();
    }

}
