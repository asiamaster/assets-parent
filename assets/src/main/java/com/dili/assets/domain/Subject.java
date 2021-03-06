package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;

import javax.persistence.*;
import java.util.Date;

/**
 * 由PD Man工具自动生成
 * 品类 ;
 * This file was generated on 2020-02-05 12:37:16.
 */
@Table(name = "`subject`")
public class Subject extends BaseDomain {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Long id;
    /**
     * 科目名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 父
     */
    @Column(name = "`parent`")
    private Long parent;
    /**
     * 路劲
     */
    @Column(name = "`path`")
    private String path;

    /**
     * 创建人
     */
    @Column(name = "`market_id`")
    private Long marketId;

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
     * 状态
     */
    @Column(name = "`memo`")
    private String memo;

    /**
     * 品类名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 品类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 父品类
     */
    public Long getParent() {
        return this.parent;
    }

    /**
     * 父品类
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }

    /**
     * 路劲
     */
    public String getPath() {
        return this.path;
    }

    /**
     * 路劲
     */
    public void setPath(String path) {
        this.path = path;
    }


    /**
     * 创建人
     */
    public Long getCreatorId() {
        return this.creatorId;
    }

    /**
     * 创建人
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getModifyTime() {
        return this.modifyTime;
    }

    /**
     * 更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 状态
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }
}