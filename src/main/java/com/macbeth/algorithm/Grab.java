package com.macbeth.algorithm;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

/**
 * author:macbeth
 * Date:2018/6/20
 * Time:11:40
 **/
public class Grab {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.lagou.com/zhaopin/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("user-agent","Mozilla/5.0");
        connection.connect();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            String str = null;
            while ((str = reader.readLine()) != null){
                bos.write(str.getBytes());
            }
            String result = bos.toString();
            result = Pattern.compile("\r|\n").matcher(result).replaceAll("");
            result = Pattern.compile("(?<=>)\\s*(?=<)").matcher(result).replaceAll("");
            System.out.println(result);
        }
    }
}
