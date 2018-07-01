package com.macbeth.algorithm.olpath.impl;

import com.google.common.collect.Sets;
import com.macbeth.algorithm.Constants;
import com.macbeth.algorithm.olpath.Parser;
import com.macbeth.algorithm.utils.StringUtils;

import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author:macbeth
 * Date:2018/6/20
 * Time:11:48
 **/
public class SimpleParser implements Parser {
    private static String TITLE_PATTER = "(?<=\\<title>)(\\w|\\|-|\\s|\\()*(?=\\<\\/title>)";
    private String content = null;

    private SimpleParser(String content){
        this.content = content;
    }
    public static SimpleParser getInstance(String content){
        return new SimpleParser(content);
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public Set<String> parseImgPath() {
        Pattern pattern = Pattern.compile(Constants.IMG_PATH_PATTERN);
        Matcher matcher = pattern.matcher(this.content);
        Set<String> set = Sets.newHashSet();
        execute(matcher,StringUtils::isLegalSuffix,set);
        return set;
    }

    @Override
    public Set<String> parseHref() {
        Pattern pattern = Pattern.compile(Constants.HREF_PATH_PATTERN);
        Matcher matcher = pattern.matcher(this.content);
        Set<String> set = Sets.newHashSet();
        execute(matcher,(x)-> ! (x.endsWith(".ico") || x.endsWith(".css")),set);
        return set;
    }

    @Override
    public String parseTitle() {
        Pattern pattern = Pattern.compile(TITLE_PATTER);
        Matcher matcher = pattern.matcher(this.content);
        Set<String> set = Sets.newHashSet();
        execute(matcher,x -> true,set);
        return set.iterator().next();
    }

    private void execute(Matcher matcher, Predicate<String> predicate,Set<String> set){
        while (matcher.find()){
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            String result = this.content.substring(startIndex,endIndex);
            if (StringUtils.isEmpty(result) || ! predicate.test(result))
                continue;
            if (result.startsWith("//"))
                result = "http:" + result;
            else if (result.startsWith("/"))
                result = "http://www.mtl030.com" + result;
            else
                result = "http://www.mtl030.com" + "/" + result;
            result = Pattern.compile("\\/$").matcher(result).replaceAll("");
            set.add(result);
        }
    }
}




















