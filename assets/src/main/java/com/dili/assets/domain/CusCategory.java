package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * 由PD Man工具自动生成
 * 品类 ;
 * This file was generated on 2020-02-05 12:37:16.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "cus_category")
public class CusCategory extends BaseDomain {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Long id;
    /**
     * 品类名称
     */
    @Column(name = "`name`")
    private String name;
    /**
     * 拼音
     */
    @Column(name = "`pingying`")
    private String pingying;
    /**
     * 拼音缩写
     */
    @Column(name = "`py_initials`")
    private String pyInitials;

    /**
     * 拼音缩写
     */
    @Column(name = "`icon`")
    private String icon;

    /**
     * 市场
     */
    @Column(name = "`market_id`")
    private Long marketId;

    /**
     * 父品类
     */
    @Column(name = "`parent`")
    private Long parent;
    /**
     * 路劲
     */
    @Column(name = "`path`")
    private String path;
    /**
     * 快捷码
     */
    @Column(name = "`keycode`")
    private String keycode;
    /**
     * 创建人
     */
    @Column(name = "`creator_id`")
    private Long creatorId;
    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "`modify_time`")
    private Date modifyTime;

    /**
     * 状态
     */
    @Column(name = "`state`")
    private Integer state;

    /**
     * 集团品类
     */
    @Column(name = "`category_id`")
    private Long categoryId;


}
