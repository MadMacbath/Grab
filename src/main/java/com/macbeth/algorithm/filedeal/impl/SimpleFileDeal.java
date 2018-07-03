package com.macbeth.algorithm.filedeal.impl;


import com.macbeth.algorithm.filedeal.FileDeal;
import com.macbeth.algorithm.utils.StringUtils;
import com.macbeth.algorithm.utils.TimeUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Set;

/**
 * author:macbeth
 * Date:2018/6/20
 * Time:14:23
 **/
public class SimpleFileDeal implements FileDeal {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private static Random random = new Random();

    @Override
    public void saveFile(Set<String> urls,String basePath) {
        if (urls == null) return;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final long startTime = System.currentTimeMillis();
        urls.stream().forEach(url -> {
            try {
                String suffix = StringUtils.getSuffix(url);
                if (StringUtils.isEmpty(suffix)) return;
                URL imgUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) imgUrl.openConnection();
                connection.setRequestProperty("user-agent", "Mozzilla/5.0");
                connection.setUseCaches(false);
                connection.setConnectTimeout(1000);
                connection.connect();
                try (InputStream is = connection.getInputStream()) {
                    int index = 0;
                    byte[] buff = new byte[2048 * 10];
                    while ((index = is.read(buff)) != -1) {
                        bos.write(buff, 0, index);
                    }
                }
                while (true){
                    Path file = Paths.get(basePath + "/" + System.currentTimeMillis() + "+" + random.nextInt(10000) + suffix);
                    if (Files.exists(file)) continue;
                    Files.createFile(file);
                    Files.write(file,bos.toByteArray());
                    TimeUtils.endTime(startTime,"saveFile",url, false);
                    break;
                }
                bos.reset();
            } catch (Exception e) {
                System.out.println(url);
            }
        });
    }
}





















