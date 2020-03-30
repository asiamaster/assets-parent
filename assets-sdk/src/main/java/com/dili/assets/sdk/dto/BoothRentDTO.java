package com.dili.assets.sdk.dto;

import com.dili.ss.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 由MyBatis Generator工具自动生成
 * 租赁时间表
 * This file was generated on 2020-03-03 14:37:36.
 */
public class BoothRentDTO extends BaseDomain {

    /**
     * 主键
     */
    private Long id;
    /**
     * 业务单号
     */
    private String orderId;
    /**
     * 摊位编号
     */
    private Long boothId;
    /**
     * 开始日期
     */
    private Date start;
    /**
     * 结束时间
     */
    private Date end;

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

    /**
     * 摊位编号
     */
    public Long getBoothId() {
        return this.boothId;
    }

    /**
     * 摊位编号
     */
    public void setBoothId(Long boothId) {
        this.boothId = boothId;
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
}