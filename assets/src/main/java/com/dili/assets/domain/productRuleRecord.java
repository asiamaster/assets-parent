package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import java.util.Date;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 商品单价生效时间
 * This file was generated on 2020-05-12 10:35:29.
 */
@Table(name = "`product_rule_record`")
public class productRuleRecord extends BaseDomain {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`rule_id`")
    private Long ruleId;

    @Column(name = "`org_price`")
    private Double orgPrice;

    @Column(name = "`next_price`")
    private Double nextPrice;

    @Column(name = "`effect_time`")
    private Date effectTime;

    @Column(name = "`operator_name`")
    private String operatorName;

    @Column(name = "`created`")
    private Date created;

    @Column(name = "`modified`")
    private Date modified;

    /**
     * @return id
     */
    @FieldDef(label="id")
    @EditMode(editor = FieldEditor.Number, required = true)
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return rule_id
     */
    @FieldDef(label="ruleId")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * @param ruleId
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * @return org_price
     */
    @FieldDef(label="orgPrice")
    @EditMode(editor = FieldEditor.Text, required = false)
    public Double getOrgPrice() {
        return orgPrice;
    }

    /**
     * @param orgPrice
     */
    public void setOrgPrice(Double orgPrice) {
        this.orgPrice = orgPrice;
    }

    /**
     * @return next_price
     */
    @FieldDef(label="nextPrice")
    @EditMode(editor = FieldEditor.Text, required = false)
    public Double getNextPrice() {
        return nextPrice;
    }

    /**
     * @param nextPrice
     */
    public void setNextPrice(Double nextPrice) {
        this.nextPrice = nextPrice;
    }

    /**
     * @return effect_time
     */
    @FieldDef(label="effectTime")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    public Date getEffectTime() {
        return effectTime;
    }

    /**
     * @param effectTime
     */
    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    /**
     * @return operator_name
     */
    @FieldDef(label="operatorName", maxLength = 50)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * @param operatorName
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * @return created
     */
    @FieldDef(label="created")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return modified
     */
    @FieldDef(label="modified")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    public Date getModified() {
        return modified;
    }

    /**
     * @param modified
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }
}