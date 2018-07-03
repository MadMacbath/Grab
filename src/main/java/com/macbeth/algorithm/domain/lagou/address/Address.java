package com.macbeth.algorithm.domain.lagou.address;

import lombok.Data;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:04
 **/
@Data
public class Address {
    private Long id;
    // 描述
    private String desc;
    // 省/直辖市
    private Province province;
    // 市/区
    private City city;
    // 地点
    private Location location;
}
