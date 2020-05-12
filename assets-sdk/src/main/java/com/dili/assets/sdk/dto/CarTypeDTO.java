package com.dili.assets.sdk.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.dili.ss.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 由MyBatis Generator工具自动生成
 * 摊位 ;
 * This file was generated on 2020-02-17 13:21:57.
 */
public class CarTypeDTO extends BaseDomain {
	/**
     * id
     */
    private Long id;

    /**
     * 市场
     */
    private Long marketId;

    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;

    /**
     * 修改时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modified;

    /**
     * 操作员ID
     */
    private Long operatorId;

    /**
     * 操作员名称
     */
    private String operatorName;

    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 皮重
     */
    private Long weight;

    /**
     * 状态
     */
    private Long status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取市场
     *
     * @return market_id - 市场
     */
    public Long getMarketId() {
        return marketId;
    }

    /**
     * 设置市场
     *
     * @param marketId 市场
     */
    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    /**
     * 获取创建时间
     *
     * @return CREATED - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取修改时间
     *
     * @return MODIFIED - 修改时间
     */
    public Date getModified() {
        return modified;
    }

    /**
     * 设置修改时间
     *
     * @param modified 修改时间
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * 获取操作员ID
     *
     * @return operator_id - 操作员ID
     */
    public Long getOperatorId() {
        return operatorId;
    }

    /**
     * 设置操作员ID
     *
     * @param operatorId 操作员ID
     */
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取操作员名称
     *
     * @return operator_name - 操作员名称
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置操作员名称
     *
     * @param operatorName 操作员名称
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * 获取代码
     *
     * @return code - 代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置代码
     *
     * @param code 代码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取皮重
     *
     * @return weight - 皮重
     */
    public Long getWeight() {
        return weight;
    }

    /**
     * 设置皮重
     *
     * @param weight 皮重
     */
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Long getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}