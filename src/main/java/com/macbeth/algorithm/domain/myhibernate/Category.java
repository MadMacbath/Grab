package com.macbeth.algorithm.domain.myhibernate;

import com.google.common.collect.Sets;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * author:macbeth
 * Date:2018/7/9
 * Time:16:22
 **/
@Data
@ToString
@Entity
@Table(name = "MY_CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Transient
    private Category parentCategory;
    @Transient
    private Set<Category> childCategories = Sets.newHashSet();
    @Transient
    private Set<Item> items = Sets.newHashSet();
}






























