package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;

import javax.persistence.*;
import java.util.Date;

/**
 * 由MyBatis Generator工具自动生成
 * 租赁时间表
 * This file was generated on 2020-03-03 14:37:36.
 */
@Table(name = "`booth_rent`")
public class BoothRent extends BaseDomain {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Long id;
    /**
     * 业务单号
     */
    @Column(name = "`order_id`")
    private String orderId;
    /**
     * 摊位编号
     */
    @Column(name = "`booth_id`")
    private Long assetsId;
    /**
     * 开始日期
     */
    @Column(name = "`start`")
    private Date start;
    /**
     * 结束时间
     */
    @Column(name = "`end`")
    private Date end;


    /** 类型 */
    @Column(name = "`type`")
    private Integer type ;
    /** 数量 */
    @Column(name = "`number`")
    private Double number ;
    /** 使用方 */
    @Column(name = "`user`")
    private String user ;

    /**
     * 冻结状态
     */
    @Column(name = "`freeze`")
    private Integer freeze;

    /**
     * 主键
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 业务单号
     */
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * 业务单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(Long assetsId) {
        this.assetsId = assetsId;
    }

    /**
     * 开始日期
     */
    public Date getStart() {
        return this.start;
    }

    /**
     * 开始日期
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * 结束时间
     */
    public Date getEnd() {
        return this.end;
    }

    /**
     * 结束时间
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getFreeze() {
        return freeze;
    }

    public void setFreeze(Integer freeze) {
        this.freeze = freeze;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}