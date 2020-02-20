package com.dili.assets.sdk.dto;

import com.dili.ss.domain.BaseDomain;

import java.util.Date;

/**
 * 由MyBatis Generator工具自动生成
 * 区域 ;
 * This file was generated on 2020-02-17 11:17:18.
 */
public class DistrictDTO extends BaseDomain {
    /**
     * id
     */
    private Long id;
    /**
     * 创建人
     */
    private Long creatorId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date modifyTime;
    /**
     * 区域名称
     */
    private String name;
    /**
     * 备注
     */
    private String notes;
    /**
     * 部门
     */
    private Long departmentId;
    /**
     * 负责人
     */
    private Long owner;
    /**
     * 市场
     */
    private Long marketId;
    /**
     * 父区域
     */
    private Long parentId;
    /**
     * 排序
     */
    private String sort;
    /**
     * 编号
     */
    private String number;
    /**
     * 状态
     */
    private Integer isDelete;

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
     * 区域名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 区域名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 备注
     */
    public String getNotes() {
        return this.notes;
    }

    /**
     * 备注
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * 部门
     */
    public Long getDepartmentId() {
        return this.departmentId;
    }

    /**
     * 部门
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 负责人
     */
    public Long getOwner() {
        return this.owner;
    }

    /**
     * 负责人
     */
    public void setOwner(Long owner) {
        this.owner = owner;
    }

    /**
     * 市场
     */
    public Long getMarketId() {
        return this.marketId;
    }

    /**
     * 市场
     */
    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    /**
     * 父区域
     */
    public Long getParentId() {
        return this.parentId;
    }

    /**
     * 父区域
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 排序
     */
    public String getSort() {
        return this.sort;
    }

    /**
     * 排序
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 编号
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * 编号
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 状态
     */
    public Integer getIsDelete() {
        return this.isDelete;
    }

    /**
     * 状态
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}