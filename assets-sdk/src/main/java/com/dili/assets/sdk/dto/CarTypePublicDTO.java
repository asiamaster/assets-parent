package com.dili.assets.sdk.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.dili.ss.domain.BaseDomain;
import com.dili.uap.sdk.domain.DataDictionaryValue;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 由MyBatis Generator工具自动生成
 * 车型
 * This file was generated on 2020-05-18 14:41:03.
 */
@Table(name = "`car_type_public`")
public class CarTypePublicDTO extends BaseDomain {
    /**
     * id
     */
    private Long id;

    /**
     * 市场
     */
    private Long marketId;

    /**
     * 车型
     */
    private Long carTypeId;

    /**
     * 快捷编码
     */
    private String code;
    
    /**
     * 标签
     */
    @Column(name = "`tag`")
    private String tag;

    /**
     * 自动放行
     */
    private Integer autoPass;
    /**
     * 自动放行
     */
    @Column(name = "`auto_save`")
    private Integer autoSave;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;
    
    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /**
     * 创建人
     */
    private Long creatorId;
    
    /**
     * 车型
     */
    private CarTypeDTO carType;
    /**
     * 标签
     */
    private List<TagExtDTO> tagExt;
    
    /**
     * 业务编码
     */
    @Transient
    private String businessCode;
    
    /**
     * 业务编码
     */
    @Transient
    private String keyword;
    
    @Transient
    private String number;
    
    @Transient
    private String name;
    
    private List<Long> ids;
    
    @Transient
    private List<DataDictionaryValue> tags;

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
     * @return market_code - 市场
     */
    public Long getMarketId() {
        return marketId;
    }

    /**
     * 设置市场
     *
     * @param marketCode 市场
     */
    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    /**
     * 获取车型
     *
     * @return car_type_id - 车型
     */
    public Long getCarTypeId() {
        return carTypeId;
    }

    /**
     * 设置车型
     *
     * @param carTypeId 车型
     */
    public void setCarTypeId(Long carTypeId) {
        this.carTypeId = carTypeId;
    }

    /**
     * 获取快捷编码
     *
     * @return code - 快捷编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置快捷编码
     *
     * @param code 快捷编码
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

    /**
     * 获取自动放行
     *
     * @return auto_pass - 自动放行
     */
    public Integer getAutoPass() {
        return autoPass;
    }

    /**
     * 设置自动放行
     *
     * @param aotuPass 自动放行
     */
    public void setAutoPass(Integer autoPass) {
        this.autoPass = autoPass;
    }
    public Integer getAutoSave() {
		return autoSave;
	}

	public void setAutoSave(Integer autoSave) {
		this.autoSave = autoSave;
	}
    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
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

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取创建人
     *
     * @return creator_id - 创建人
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人
     *
     * @param creatorId 创建人
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

	public CarTypeDTO getCarType() {
		return carType;
	}

	public void setCarType(CarTypeDTO carType) {
		this.carType = carType;
	}

	
	public List<TagExtDTO> getTagExt() {
		return tagExt;
	}

	public void setTagExt(List<TagExtDTO> tagExt) {
		this.tagExt = tagExt;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public List<DataDictionaryValue> getTags() {
		return tags;
	}

	public void setTags(List<DataDictionaryValue> tags) {
		this.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}