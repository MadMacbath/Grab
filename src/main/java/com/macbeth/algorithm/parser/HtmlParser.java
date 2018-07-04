package com.macbeth.algorithm.parser;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:13:48
 **/
public class HtmlParser {
    public Document getDocument(String href) throws IOException {
        URL url = new URL(href);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("user-agent","Mozilla/5.0");
        connection.connect();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Document document = new Document(new Dom());
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            String str = null;
            while ((str = reader.readLine()) != null){
                bos.write(str.getBytes());
            }
            String result = bos.toString();
            result = Pattern.compile("\r|\n").matcher(result).replaceAll("");
            result = Pattern.compile("(?<=>)\\s*(?=<)").matcher(result).replaceAll("");
            Dom root = new Dom();
            char[] chars = result.toCharArray();
            for (int index = 0; index < chars.length; index++){
                char current = chars[index];
                if (current == '<'){

                }
            }
        }
        return document;
    }

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.lagou.com/zhaopin/");
    }
}























