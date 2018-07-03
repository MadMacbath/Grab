package com.macbeth.algorithm.parser.impl;

import com.google.common.collect.Sets;
import com.macbeth.algorithm.Domain;
import com.macbeth.algorithm.domain.Page;
import com.macbeth.algorithm.parser.Parser;
import com.macbeth.algorithm.utils.StringUtils;
import lombok.Data;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:48
 **/
@Data
public class SimpleParser implements Parser {
    private String url;
    private String content;
    private SimpleParser(String url){
        this.url = url;
    }
    // 返回null表示未准备就绪，应立即终止运行
    public static Parser getInstance(String url){
        SimpleParser parser = new SimpleParser(url);
        String content = parser.getContent();
        if (StringUtils.isEmpty(content)) return null;
        return parser;
    }
    public Set<String> parseHrefs() {
        Pattern pattern = Pattern.compile("(?<=href=\")(\\w|\\.|\\/)*(?=\")");
        Set<String> sets = this.execute(pattern);
        if (sets == null || sets.size() <= 0) return null;
        return sets;
    }

    public Set<String> paseImgs() {
        return null;
    }

    private Set<String> execute(Pattern pattern){
        Matcher matcher = pattern.matcher(this.content);
        Set<String> sets = Sets.newHashSet();
        String result = "";
        while (matcher.find()){
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            result = this.content.substring(startIndex,endIndex);
            if (! result.endsWith(".html")) continue;
            sets.add(this.content.substring(startIndex,endIndex));
        }
        return sets;
    }

    public String getContent(String targetUrl){
        try {
            URL url = new URL(targetUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("user-agent","Mozzila/5.0");
            connection.setConnectTimeout(1000);
            connection.setUseCaches(false);
            connection.connect();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                String str = null;
                while ((str = reader.readLine()) != null){
                    bos.write(str.getBytes());
                }
            }
            String result = bos.toString();
            if (StringUtils.isEmpty(result)) return null;
            result = Pattern.compile("\r|\n").matcher(result).replaceAll("");
            result = Pattern.compile("(?<=>)\\s*(?=<)").matcher(result).replaceAll("");
            return result;
        } catch (MalformedURLException e) {
            System.out.println("畸形的URL:::" + url);
        } catch (IOException e) {
            System.out.println("IO错误:::" + url);
        }
        return null;
    }
}
