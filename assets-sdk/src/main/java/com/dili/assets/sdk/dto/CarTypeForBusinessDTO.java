package com.dili.assets.sdk.dto;

import java.util.List;

import javax.persistence.Column;

/**
 * 由MyBatis Generator工具自动生成
 * 车型
 * This file was generated on 2020-05-09 16:44:34.
 */
public class CarTypeForBusinessDTO {
    /**
     * id
     */
    private Long id;

    /**
     * 编号
     */
    private String number;

    /**
     * 名称
     */
    private String carTypeName;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 自动放行
     */
    private Integer autoPass;
    
    /**
     * 自动存储
     */
    private Integer autoSave;
    
    /**
     * 快捷编码
     */
    private String code;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 重量
     */
    private Long weight;

    /**
     * 标签
     */
    private String tag;
    
    private List<Long> ids;
    
    /**
     * 业务编码
     */
    private String businessCode;
    
    /**
     * 业务编码
     */
    private String keyword;
    
    /**
     * 市场
     */
    private Long marketId;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAutoPass() {
		return autoPass;
	}

	public void setAutoPass(Integer autoPass) {
		this.autoPass = autoPass;
	}

	public Integer getAutoSave() {
		return autoSave;
	}

	public void setAutoSave(Integer autoSave) {
		this.autoSave = autoSave;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    
}