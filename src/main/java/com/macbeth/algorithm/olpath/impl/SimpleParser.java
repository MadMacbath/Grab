package com.macbeth.algorithm.olpath.impl;

import com.google.common.collect.Sets;
import com.macbeth.algorithm.Constants;
import com.macbeth.algorithm.olpath.Parser;
import com.macbeth.algorithm.utils.StringUtils;
import lombok.Data;

import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author:macbeth
 * Date:2018/6/20
 * Time:11:48
 **/
@Data
public class SimpleParser implements Parser {
    private static String TITLE_PATTER = "(?<=<title>)(\\w|-|[\\u4e00-\\u9fa5])*(?=</title>)";
    private String content = null;

    @Override
    public Set<String> parseImgPath() {
        Pattern pattern = Pattern.compile(Constants.IMG_PATH_PATTERN);
        if (StringUtils.isEmpty(this.content)) return null;
        Matcher matcher = pattern.matcher(this.content);
        Set<String> set = Sets.newHashSet();
        execute(matcher,StringUtils::isLegalSuffix,set);
        return set;
    }

    @Override
    public Set<String> parseHref() {
        if (StringUtils.isEmpty(this.content)) return null;
        Pattern pattern = Pattern.compile(Constants.HREF_PATH_PATTERN);
        Matcher matcher = pattern.matcher(this.content);
        Set<String> set = Sets.newHashSet();
        execute(matcher,(x)-> ! (x.endsWith(".ico") || x.endsWith(".css")),set);
        return set;
    }

    @Override
    public String parseTitle() {
        if (StringUtils.isEmpty(this.content)) return null;
        Pattern pattern = Pattern.compile(TITLE_PATTER);
        Matcher matcher = pattern.matcher(this.content);
        String result = null;
        if (matcher.find()){
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            result = this.content.substring(startIndex,endIndex);
            result = result.replaceAll("\\/","");
        }
        if (result == null){
            result = System.currentTimeMillis() + "";
        }
        return result;
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
                result = Constants.URL_PATH + result;
            else if (result.startsWith("http")) {

            }else
                result = Constants.URL_PATH + "/" + result;
            result = Pattern.compile("\\/$").matcher(result).replaceAll("");
            set.add(result);
        }
    }

    public static void main(String[] args) {
        String str = "//csdnimg.cn/feed/20180702/0a53811b7d2c3e94187591848796a265.png";
        if (str.startsWith("//")){
            System.out.println("first");
        }else if (str.startsWith("/")){
            System.out.println("second");
        }else {
            System.out.println("3");
        }
    }
}




















