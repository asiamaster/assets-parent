package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;

import javax.persistence.*;
import java.util.Date;

/**
 * 由PD Man工具自动生成
 * 品类 ;
 * This file was generated on 2020-02-05 12:37:16.
 */
@Table(name = "`category`")
public class Category extends BaseDomain {
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
     * 编码
     */
    @Column(name = "`code`")
    private String code;
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
     * 层级
     */
    @Column(name = "`cate_level`")
    private Integer cateLevel;

    /**
     * id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * id
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * 拼音
     */
    public String getPingying() {
        return this.pingying;
    }

    /**
     * 拼音
     */
    public void setPingying(String pingying) {
        this.pingying = pingying;
    }

    /**
     * 拼音缩写
     */
    public String getPyInitials() {
        return this.pyInitials;
    }

    /**
     * 拼音缩写
     */
    public void setPyInitials(String pyInitials) {
        this.pyInitials = pyInitials;
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
     * 编码
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 编码
     */
    public void setCode(String code) {
        this.code = code;
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

    public Integer getCateLevel() {
        return cateLevel;
    }

    public void setCateLevel(Integer cateLevel) {
        this.cateLevel = cateLevel;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}