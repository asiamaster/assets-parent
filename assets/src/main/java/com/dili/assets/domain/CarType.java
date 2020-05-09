package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import java.util.Date;
import javax.persistence.*;

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
     * 市场
     */
    @Column(name = "`market_id`")
    private Long marketId;

    /**
     * 创建时间
     */
    @Column(name = "`CREATED`")
    private Date created;

    /**
     * 修改时间
     */
    @Column(name = "`MODIFIED`")
    private Date modified;

    /**
     * 操作员ID
     */
    @Column(name = "`operator_id`")
    private Long operatorId;

    /**
     * 操作员名称
     */
    @Column(name = "`operator_name`")
    private String operatorName;

    /**
     * 代码
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 皮重
     */
    @Column(name = "`weight`")
    private Long weight;

    /**
     * 状态
     */
    @Column(name = "`status`")
    private Long status;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

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
     * @return market_id - 市场
     */
    @FieldDef(label="市场")
    @EditMode(editor = FieldEditor.Number, required = false)
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
    @FieldDef(label="创建时间")
    @EditMode(editor = FieldEditor.Datetime, required = true)
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
    @FieldDef(label="修改时间")
    @EditMode(editor = FieldEditor.Datetime, required = true)
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
    @FieldDef(label="操作员ID")
    @EditMode(editor = FieldEditor.Number, required = false)
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
    @FieldDef(label="操作员名称", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
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
    @FieldDef(label="代码", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
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
     * 获取皮重
     *
     * @return weight - 皮重
     */
    @FieldDef(label="皮重")
    @EditMode(editor = FieldEditor.Number, required = false)
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
    @FieldDef(label="状态")
    @EditMode(editor = FieldEditor.Number, required = false)
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
}