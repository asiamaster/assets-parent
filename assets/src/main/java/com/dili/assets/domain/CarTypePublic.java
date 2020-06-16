package com.dili.assets.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;

/**
 * 由MyBatis Generator工具自动生成
 * 车型
 * This file was generated on 2020-05-18 14:41:03.
 */
@Table(name = "`car_type_public`")
public class CarTypePublic extends BaseDomain {
    /**
     * id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 市场
     */
    @Column(name = "`market_id`")
    private Long marketId;

    /**
     * 车型
     */
    @Column(name = "`car_type_id`")
    private Long carTypeId;

    /**
     * 快捷编码
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 标签
     */
    @Column(name = "`tag`")
    private String tag;
    
    /**
     * 自动放行
     */
    @Column(name = "`auto_pass`")
    private Integer autoPass;
    /**
     * 自动放行
     */
    @Column(name = "`auto_save`")
    private Integer autoSave;

    /**
     * 状态
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "`modify_time`")
    private Date modifyTime;

    /**
     * 创建人
     */
    @Column(name = "`creator_id`")
    private Long creatorId;
    
    /**
     * 车型
     */
    private CarType carType;
    
    /**
     * 标签
     */
    private List<TagExt> tagExt;
    
    /**
     * 业务编码
     */
    @Transient
    private String businessCode;
    
    /**
     * 业务编码
     */
    @Transient
    private String carName;
    
    /**
     * 获取id
     *
     * @return id - id
     */
    @FieldDef(label="id")
    @EditMode(editor = FieldEditor.Number, required = true)
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
    @FieldDef(label="市场")
    @EditMode(editor = FieldEditor.Number, required = false)
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
    @FieldDef(label="车型")
    @EditMode(editor = FieldEditor.Number, required = true)
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
    @FieldDef(label="快捷编码", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
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
    @FieldDef(label="自动放行")
    @EditMode(editor = FieldEditor.Number, required = false)
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
    @FieldDef(label="状态")
    @EditMode(editor = FieldEditor.Number, required = false)
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
    @FieldDef(label="备注", maxLength = 200)
    @EditMode(editor = FieldEditor.Text, required = false)
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
    @FieldDef(label="创建时间")
    @EditMode(editor = FieldEditor.Datetime, required = true)
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
    @FieldDef(label="修改时间")
    @EditMode(editor = FieldEditor.Datetime, required = true)
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
    @FieldDef(label="创建人")
    @EditMode(editor = FieldEditor.Number, required = false)
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

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	
	public List<TagExt> getTagExt() {
		return tagExt;
	}

	public void setTagExt(List<TagExt> tagExt) {
		this.tagExt = tagExt;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}
}