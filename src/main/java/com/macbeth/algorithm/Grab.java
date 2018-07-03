package com.macbeth.algorithm;


import com.google.common.collect.Sets;
import com.macbeth.algorithm.filedeal.FileDeal;
import com.macbeth.algorithm.filedeal.impl.SimpleFileDeal;
import com.macbeth.algorithm.olpath.Parser;
import com.macbeth.algorithm.olpath.impl.SimpleParser;
import com.macbeth.algorithm.utils.TimeUtils;

import java.io.*;
import java.net.*;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * author:macbeth
 * Date:2018/6/20
 * Time:11:40
 **/
public class Grab {

    private Set<String> actived = Sets.newHashSet();

    public String getContent(String urlPath) throws IOException {
        long startTime = System.currentTimeMillis();
        URL url = new URL(urlPath);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setRequestProperty("user-agent","Mozilla/5.0");
        connection.setConnectTimeout(1000);
        connection.connect();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String str = null;
            while ((str = reader.readLine()) != null) {
                bos.write(str.getBytes());
            }
            String result = bos.toString();
            result = Pattern.compile("\\r|\\n").matcher(result).replaceAll("");
            result = Pattern.compile("(?<=>)\\s+(?=<)").matcher(result).replaceAll("");
            TimeUtils.endTime(startTime,"getContent",urlPath,false);
            return result;
        }
    }

    public void execute(String rootUrl) {
        long startTime = System.currentTimeMillis();
        try {
            String content = getContent(rootUrl);
            Parser parser = SimpleParser.getInstance(content);
            Set<String> imgUrls = parser.parseImgPath();
            System.out.println(imgUrls);
            FileDeal deal = SimpleFileDeal.getInstance();
//            deal.saveFile(imgUrls);
            Set<String> hrefs = parser.parseHref();
            if (hrefs == null || hrefs.size() == 0) {
                return;
            }
            for (String href : hrefs) {
                if (actived.contains(href))
                    continue;
                actived.add(href);
                TimeUtils.endTime(startTime,"execute",href,false);
                execute(href);
            }
        }catch (Exception e){
            TimeUtils.endTime(startTime,"execute",rootUrl, true);
        }
    }
    public static void main(String[] args) throws IOException {
        Grab grab = new Grab();
        grab.execute(Constants.URL_PATH);
    }
}
