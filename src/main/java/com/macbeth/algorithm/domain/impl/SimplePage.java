package com.macbeth.algorithm.domain.impl;

import com.google.common.collect.Sets;
import com.macbeth.algorithm.Constants;
import com.macbeth.algorithm.domain.Page;
import com.macbeth.algorithm.filedeal.FileDeal;
import com.macbeth.algorithm.olpath.Parser;
import com.macbeth.algorithm.utils.StringUtils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.regex.Pattern;

/***
 * @author : macbeth
 * @date   : 2018/7/1 19:39
 * @mail   : madmacbeth@163.com
 */
public class SimplePage implements Page {
    private String title;
    private String url;
    private Set<String> imgUrls;
    private Set<String> hrefUrls;
    private Parser parser;
    private FileDeal fileDeal;
    private Page parentPage;
    private Page root;
    private Set<Page> children = Sets.newHashSet();
    private String basePath;

    public static SimplePage getInstance(String url, Parser parser, FileDeal fileDeal){
        SimplePage page = new SimplePage();
        page.url = url;
        page.parser = parser;
        page.parser.setContent(page.getContent());
        page.fileDeal = fileDeal;
        page.imgUrls = page.parser.parseImgPath();
        page.hrefUrls = page.parser.parseHref();
        page.title = page.parser.parseTitle();
        return page;
    }
    public Set<Page> getChildren() {
            if (this.children.size() <= 0 && this.hrefUrls != null){
                for (String href : this.hrefUrls){
                    try {
                        Page page = getInstance(href, this.parser, this.fileDeal);
                        page.setParentPage(this);
                        page.setRoot(this.getRoot());
                        this.children.add(page);
                    }catch (Exception e){

                    }
                }
            }
        return this.children;
    }

    @Override
    public void setChildren(Set<Page> children) {
        this.children = children;
    }

    @Override
    public Page getRoot() {
        return this.root;
    }

    @Override
    public void setRoot(Page root) {
        this.root = root;
    }

    @Override
    public String getContent() {
        if (StringUtils.isEmpty(url)) return null;
        try{
            URL url = new URL(this.url);
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
                return result;
            }
        }catch (SocketTimeoutException e){
            System.out.println(url + ":::: time out");
        } catch (MalformedURLException e) {
            System.out.println(url + ":::: 畸形的URL");
        } catch (IOException e) {
            System.out.println(url + ":::: IO错误");
        }
        return null;
    }

    @Override
    public String getBasePath() {
        if (this.getParentPage() != null)
            this.basePath = this.getParentPage().getBasePath() + "/" + this.getTitle();
        else
            this.basePath = Constants.SAVE_FILE_PATH + "/" + Constants.SAVE_FILE_SECOND_PATH + "/" + this.getTitle();
        return this.basePath;
    }

    @Override
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public Page getParentPage() {
        return this.parentPage;
    }

    @Override
    public void setParentPage(Page parentPage) {
        this.parentPage = parentPage;
    }

    @Override
    public void saveImgs() {
        if (this.imgUrls == null || this.imgUrls.size() <= 0) return;
        Path path = Paths.get(this.getBasePath());
        System.out.println(this.basePath);
        if (! Files.exists(path)){
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.out.println("创建目录失败");
            }
        }
        this.fileDeal.saveFile(this.imgUrls, this.basePath);
    }

    public void ergodicSaveImg(Page target) throws IOException {
        if (target == null) return;
        target.saveImgs();
        Set<Page> children = target.getChildren();
        if (children.size() > 0){
            for (Page page : children){
                ergodicSaveImg(page);
            }
        }
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void SetTitle(String title) {
        this.title = title;
    }
}
