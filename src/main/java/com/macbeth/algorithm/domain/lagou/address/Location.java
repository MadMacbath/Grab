package com.macbeth.algorithm.domain.lagou.address;

import lombok.Data;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:06
 **/
@Data
public class Location {
    private Long id;
    private City city;
    private String name;
}
