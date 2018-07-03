package com.macbeth.algorithm.domain.lagou;

import com.macbeth.algorithm.domain.lagou.address.Address;
import com.macbeth.algorithm.enumeration.ManageType;
import lombok.Data;

import java.util.Date;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:15
 **/
@Data
public class Company {
    private Long id;
    private String name;
    private String desc;
    // 规模
    private String scale;
    private Address address;
    // 经营类型
    private ManageType manageType;
    // 成立时间
    private Date establishTime;
}
