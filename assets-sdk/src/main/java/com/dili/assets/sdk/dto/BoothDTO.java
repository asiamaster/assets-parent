package com.dili.assets.sdk.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dili.ss.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;

/**
 * 由MyBatis Generator工具自动生成
 * 摊位 ;
 * This file was generated on 2020-02-17 13:21:57.
 */
public class BoothDTO extends BaseDomain {
    /**
     * id
     */
    private Long id;
    /**
     * 摊位名称
     */
    private String name;
    /**
     * 数量
     */
    private Double number;
    /**
     * 单位
     */
    private String unit;
    /**
     * 区域
     */
    private Integer area;
    /**
     * 区域
     */
    private Integer secondArea;
    /**
     * 摊位类型
     */
    private Integer type;
    /**
     * 所属部门
     */
    private Integer departmentId;
    /**
     * 市场
     */
    private Long marketId;
    /**
     * 父摊位
     */
    private Long parentId;
    /**
     * 备注
     */
    private String notes;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 是否删除
     */
    private Integer isDelete;
    /**
     * 拆分备注
     */
    private String splitNotes;
    /**
     * 创建人
     */
    private Long creatorId;

    /** 业务类型;1:摊位，2:冷库，3:公寓 */
    private Integer businessType ;
    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    private Integer corner;

    private Date startTime;
    private Date endTime;
    private Double startNumber;
    private Double endNumber;
    private String deps;

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
     * 摊位名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 摊位名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 数量
     */
    public Double getNumber() {
        return this.number;
    }

    /**
     * 数量
     */
    public void setNumber(Double number) {
        this.number = number;
    }

    /**
     * 单位
     */
    public String getUnit() {
        return this.unit;
    }

    /**
     * 单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 区域
     */
    public Integer getArea() {
        return this.area;
    }

    /**
     * 区域
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * 摊位类型
     */
    public Integer getType() {
        return this.type;
    }

    /**
     * 摊位类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 所属部门
     */
    public Integer getDepartmentId() {
        return this.departmentId;
    }

    /**
     * 所属部门
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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
     * 父摊位
     */
    public Long getParentId() {
        return this.parentId;
    }

    /**
     * 父摊位
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    /**
     * 是否删除
     */
    public Integer getIsDelete() {
        return this.isDelete;
    }

    /**
     * 是否删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 拆分备注
     */
    public String getSplitNotes() {
        return this.splitNotes;
    }

    /**
     * 拆分备注
     */
    public void setSplitNotes(String splitNotes) {
        this.splitNotes = splitNotes;
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

    /** 业务类型;1:摊位，2:冷库，3:公寓 */
    public Integer getBusinessType(){
        return this.businessType;
    }
    /** 业务类型;1:摊位，2:冷库，3:公寓 */
    public void setBusinessType(Integer businessType){
        this.businessType = businessType;
    }

    public Integer getSecondArea() {
        return secondArea;
    }

    public void setSecondArea(Integer secondArea) {
        this.secondArea = secondArea;
    }

    public Integer getCorner() {
        return corner;
    }

    public void setCorner(Integer corner) {
        this.corner = corner;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Double startNumber) {
        this.startNumber = startNumber;
    }

    public Double getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(Double endNumber) {
        this.endNumber = endNumber;
    }

    public String getDeps() {
        return deps;
    }

    public void setDeps(String deps) {
        this.deps = deps;
    }

    // ==========================字段转义==================================== //
    private String unitName;
    private String areaName;
    private String secondAreaName;
    private String departmentName;
    private String cornerName;
    private String creatorUser;

    public String getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(String creatorUser) {
        this.creatorUser = creatorUser;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getSecondAreaName() {
        return secondAreaName;
    }

    public void setSecondAreaName(String secondAreaName) {
        this.secondAreaName = secondAreaName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCornerName() {
        return cornerName;
    }

    public void setCornerName(String cornerName) {
        this.cornerName = cornerName;
    }

    // ==========================字段转义==================================== //
}