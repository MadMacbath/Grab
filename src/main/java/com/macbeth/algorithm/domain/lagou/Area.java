package com.macbeth.algorithm.domain.lagou;

import lombok.Data;

/**
 * author:macbeth
 * Date:2018/7/6
 * Time:14:09
 **/
@Data
public class Area {
    private Long areaId;
    private String areaCode;
    private String areaName;
    private int level;
    private String cityCode;
    private String center;
    private Long parentId;
}
