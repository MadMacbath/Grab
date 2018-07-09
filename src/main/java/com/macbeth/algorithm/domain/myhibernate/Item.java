package com.macbeth.algorithm.domain.myhibernate;

import com.google.common.collect.Sets;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * author:macbeth
 * Date:2018/7/9
 * Time:16:40
 **/
@Data
@ToString
@Entity
@Table(name = "MY_ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private BigDecimal initialPrice;
    private BigDecimal reservePrice;
//    private Date startDate;
//    private Date endDate;
//    private Date approveDatetime;
    @Transient
    private Set<Category> categories = Sets.newHashSet();
}




















