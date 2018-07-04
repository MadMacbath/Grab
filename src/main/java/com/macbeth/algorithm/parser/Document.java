package com.macbeth.algorithm.parser;

import lombok.Data;

import java.util.List;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:16:48
 **/
@Data
public class Document {
    private Dom root;

    public Document(Dom root) {
        this.root = root;
    }
}
