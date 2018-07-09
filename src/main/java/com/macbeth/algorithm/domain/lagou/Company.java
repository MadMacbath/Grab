package com.macbeth.algorithm.domain.lagou;

import com.google.common.collect.Sets;
import com.macbeth.algorithm.enumeration.ManageType;
import lombok.Data;
import lombok.ToString;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.util.Set;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:15
 **/
@Data
@ToString
@Entity
@Table(name = "LAGOU_COMPANY")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name",length = 50)
    private String name;
    @Column(name = "description",length = 200)
    private String desc;
    @Transient
    private Area area;
    @Column
    private String location;
    // 规模
    @Column(name = "scale",length = 20)
    private String scale;
    // 经营类型
    @Transient
    private ManageType manageType;
}
