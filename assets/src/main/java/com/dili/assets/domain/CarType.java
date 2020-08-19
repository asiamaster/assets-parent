package com.dili.assets.domain;

import java.util.Date;

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
 * This file was generated on 2020-05-09 16:44:34.
 */
@Table(name = "`car_type`")
public class CarType extends BaseDomain {
    /**
     * id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 编号
     */
    @Column(name = "`number`")
    private String number;

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
     * 操作员ID
     */
    @Column(name = "`creator_id`")
    private Long creatorId;

    /**
     * 类型
     */
    @Column(name = "`classify`")
    private String classify;

    /**
     * 名称
     */
    @Column(name = "`name`")
    private String name;

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
     * 备注
     */
    @Transient
    private String keyword;

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
     * 获取创建时间
     *
     * @return CREATED - 创建时间
     */
    @FieldDef(label="创建时间")
    @EditMode(editor = FieldEditor.Datetime, required = true)
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return MODIFIED - 修改时间
     */
    @FieldDef(label="修改时间")
    @EditMode(editor = FieldEditor.Datetime, required = true)
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modified 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取操作员ID
     *
     * @return operator_id - 操作员ID
     */
    @FieldDef(label="操作员ID")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置操作员ID
     *
     * @param operatorId 操作员ID
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }


    /**
     * 获取类型
     *
     * @return classify - 类型
     */
    @FieldDef(label="代码", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getClassify() {
    	return classify;
    }
    
    /**
     * 设置类型
     *
     * @param classify 类型
     */
    public void setClassify(String classify) {
    	this.classify = classify;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    @FieldDef(label="名称", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
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

	public String getNumber() {
		return number;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setNumber(String number) {
		try {
			if(number != null) {
				if(number.length() == 1) {
					number = "000" + number;
				}else if(number.length() == 2) {
					number = "00" + number;
				}else if(number.length() == 3) {
					number = "0" + number;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.number = number;
	}
}