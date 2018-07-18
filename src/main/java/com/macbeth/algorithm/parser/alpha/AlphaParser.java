package com.macbeth.algorithm.parser.alpha;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.macbeth.algorithm.utils.StringUtils;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * author:macbeth
 * Date:2018/7/18
 * Time:10:21
 **/
public class AlphaParser {
    // 节点类型有两种 可自关闭和不可自关闭
    private static enum NodeType{
        SELF_CLOSE,UN_SELF_CLOSE;
    }
    // 节点读取状态: 构建节点树时，需要遍历每个字符，所以一个完整的节点可能有最多六个状态
    private static enum NodeStatus{
        WAITING("未开始"){
            @Override
            void read(Node node, CharacterReader reader){
                while (reader.hasNext()) {
                    char c = reader.nextChar();
                    if ('<' == c) continue;
                    node.setNodeStatus(TARGENAME);
                    break;
                }

            }
        },
        TARGENAME("开始状态，处于节点名区域"){
            @Override
            void read(Node node, CharacterReader reader) {
                StringBuffer targetName = new StringBuffer();
                while (reader.hasNext()){
                    char c = reader.nextChar();
                    if (StringUtils.isEmpty(c)){
                        node.setNodeStatus(PROPERTY);
                        node.setNodeName(targetName.toString());
                        break;
                    }
                    // 如果为注释
                    if ('!' == c){
                        while (reader.hasNext()){
                            c = reader.nextChar();
                            if ('>' == c) {
                                node.setNodeStatus(WAITING);
                                break;
                            }
                        }
                    }
                    if ('>' == c){
                        node.setNodeStatus(HANDING);
                        node.setNodeName(targetName.toString());
                        break;
                    }
                    targetName.append(c);
                }
            }
        },
        PROPERTY("开始状态，处于属性区域"){
            @Override
            void read(Node node, CharacterReader reader) {
                StringBuffer keyOrValue = new StringBuffer();
                Map<String,String> properties = Maps.newHashMap();
                boolean flag = false;
                while (reader.hasNext()){
                    char c= reader.nextChar();
                    if (StringUtils.isEmpty(c)){
                        if (flag){
                            String[] str = keyOrValue.toString().split("=");
                            properties.put(str[0],str[1]);
                        }
                        continue;
                    }
                    if ('/' == c){
                        reader.nextChar();
                        node.setNodeType(NodeType.SELF_CLOSE);
                        node.setNodeStatus(END);
                        break;
                    }
                    if ('>' == c){
                        node.setNodeType(NodeType.UN_SELF_CLOSE);
                        node.setNodeStatus(HANDING);
                        break;
                    }
                    if ('=' == c) flag = true;
                    keyOrValue.append(c);
                }
            }
        },
        HANDING("读取中，处于类容区域"){
            @Override
            void read(Node node, CharacterReader reader) {

            }
        },
        ENDING("结束中，处于结束区域"){
            @Override
            void read(Node node, CharacterReader reader) {

            }
        },
        END("已结束，构建完成"){
            @Override
            void read(Node node, CharacterReader reader) {

            }
        };
        abstract void read(Node node, CharacterReader reader);

        private String description;

        NodeStatus(String description){
            this.description = description;
        }

        @Override
        public String toString() {
            return this.description;
        }
    }
    // 节点对象
    @Data
    private static class Node{
        private String nodeName;
        private NodeType nodeType;
        private NodeStatus nodeStatus = NodeStatus.WAITING;
        // 属性键值对
        private List<Map<String,String>> properties = Lists.newArrayList();
        // 子节点
        private List<Node> children = Lists.newArrayList();
    }
    // 字符读取
    @Data
    private static class CharacterReader{
        private int current;
        private int length;
        private char[] chars;

        public CharacterReader(String target){
            this.chars = target.toCharArray();
            this.current = -1;
            this.length = this.chars.length;
        }

        public char nextChar() {
            return this.chars[++ this.current];
        }

        public boolean hasNext(){
            return this.current >= this.length - 1;
        }
    }
    // 文档类
    @Data
    private static class Document{
        private Node root;
        private CharacterReader characterReader;

        public Document(String target){
            this.characterReader = new CharacterReader(target);
            this.root = new Node();
            parser(root);
        }

        private void parser(Node node) {
            while (true){
                node.getNodeStatus().read(node,this.characterReader);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.mybatis.org/spring/zh/mappers.html");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("user-agent","Mozilla/5.0");
        connection.connect();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            String str = "";
            StringBuffer sb = new StringBuffer();
            String result = "";
            while ((str = reader.readLine()) != null){
                sb.append(str);
            }
            result = sb.toString();
            result = Pattern.compile("\r|\n").matcher(result).replaceAll("");
            result = Pattern.compile("(?<=>)\\s*(?=<)").matcher(result).replaceAll("");
            System.out.println(result);
        }

        NodeStatus status= NodeStatus.WAITING;
    }
}
































