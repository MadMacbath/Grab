package com.macbeth.algorithm.domain.lagou;

import com.macbeth.algorithm.domain.lagou.address.Address;
import com.macbeth.algorithm.enumeration.JobLabel;
import com.macbeth.algorithm.enumeration.JobType;
import com.sun.xml.internal.ws.api.addressing.AddressingPropertySet;
import lombok.Data;

import java.util.Date;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:9:45
 **/
// 职位信息表
@Data
public class JobInformation {
    private Long id;
    private String jobName;
    // 职位要求概述
    private String jobRequestSummary;
    // 职位类型
    private JobType jobType;
    // 职位标签
    private JobLabel jobLabel;
    // 发布时间
    private Date publishTime;
    // 职位诱惑
    private String jobAdvantage;
    // 描述
    private String description;
    // 地址
    private Address address;
    // 职位要求
    private String jobRequest;
    // 发布公司
    private Company company;
}























