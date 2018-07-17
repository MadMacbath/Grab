package com.macbeth.algorithm.domain.lagou;

import com.google.common.collect.Lists;
import com.macbeth.algorithm.enumeration.ManageType;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:15
 **/
@Data
@ToString
public class Company {
    private Long id;
    private String name;
    private String description;
    private List<Area> area = Lists.newArrayList();
    private String location;
    // 规模
    private String scale;
    // 经营类型
    private ManageType manageType;
}
















