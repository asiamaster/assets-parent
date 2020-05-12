package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import java.util.Date;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 商品单价
 * This file was generated on 2020-05-12 10:35:09.
 */
@Table(name = "`product_rule`")
public class ProductRule extends BaseDomain {
    /**
     * 表主键
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
     * 商品名称
     */
    @Column(name = "`product_name`")
    private String productName;

    /**
     * 商品code
     */
    @Column(name = "`product_id`")
    private Long productId;

    /**
     * 接车部门
     */
    @Column(name = "`dep_id`")
    private Long depId;

    /**
     * 商品单价
     */
    @Column(name = "`product_price`")
    private Double productPrice;

    /**
     * 规则备注
     */
    @Column(name = "`remark`")
    private String remark;

    @Column(name = "`CREATED`")
    private Date created;

    @Column(name = "`MODIFIED`")
    private Date modified;

    @Column(name = "`operator`")
    private Long operator;

    /**
     * 操作员姓名
     */
    @Column(name = "`operator_name`")
    private String operatorName;

    /**
     * 是否有效（1：有效 -1：无效）
     */
    @Column(name = "`yn`")
    private Byte yn;

    /**
     * 商品单价快照
     */
    @Column(name = "`price_snap`")
    private String priceSnap;

    /**
     * 获取表主键
     *
     * @return id - 表主键
     */
    @FieldDef(label="表主键")
    @EditMode(editor = FieldEditor.Number, required = true)
    public Long getId() {
        return id;
    }

    /**
     * 设置表主键
     *
     * @param id 表主键
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
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    @FieldDef(label="商品名称", maxLength = 255)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取商品code
     *
     * @return product_id - 商品code
     */
    @FieldDef(label="商品code")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置商品code
     *
     * @param productId 商品code
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取接车部门
     *
     * @return dep_id - 接车部门
     */
    @FieldDef(label="接车部门")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getDepId() {
        return depId;
    }

    /**
     * 设置接车部门
     *
     * @param depId 接车部门
     */
    public void setDepId(Long depId) {
        this.depId = depId;
    }

    /**
     * 获取商品单价
     *
     * @return product_price - 商品单价
     */
    @FieldDef(label="商品单价")
    @EditMode(editor = FieldEditor.Text, required = false)
    public Double getProductPrice() {
        return productPrice;
    }

    /**
     * 设置商品单价
     *
     * @param productPrice 商品单价
     */
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取规则备注
     *
     * @return remark - 规则备注
     */
    @FieldDef(label="规则备注", maxLength = 255)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getRemark() {
        return remark;
    }

    /**
     * 设置规则备注
     *
     * @param remark 规则备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return CREATED
     */
    @FieldDef(label="created")
    @EditMode(editor = FieldEditor.Datetime, required = true)
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
     * @return MODIFIED
     */
    @FieldDef(label="modified")
    @EditMode(editor = FieldEditor.Datetime, required = true)
    public Date getModified() {
        return modified;
    }

    /**
     * @param modified
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * @return operator
     */
    @FieldDef(label="operator")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getOperator() {
        return operator;
    }

    /**
     * @param operator
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }

    /**
     * 获取操作员姓名
     *
     * @return operator_name - 操作员姓名
     */
    @FieldDef(label="操作员姓名", maxLength = 200)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置操作员姓名
     *
     * @param operatorName 操作员姓名
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * 获取是否有效（1：有效 -1：无效）
     *
     * @return yn - 是否有效（1：有效 -1：无效）
     */
    @FieldDef(label="是否有效（1：有效 -1：无效）")
    @EditMode(editor = FieldEditor.Text, required = false)
    public Byte getYn() {
        return yn;
    }

    /**
     * 设置是否有效（1：有效 -1：无效）
     *
     * @param yn 是否有效（1：有效 -1：无效）
     */
    public void setYn(Byte yn) {
        this.yn = yn;
    }

    /**
     * 获取商品单价快照
     *
     * @return price_snap - 商品单价快照
     */
    @FieldDef(label="商品单价快照", maxLength = 500)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getPriceSnap() {
        return priceSnap;
    }

    /**
     * 设置商品单价快照
     *
     * @param priceSnap 商品单价快照
     */
    public void setPriceSnap(String priceSnap) {
        this.priceSnap = priceSnap;
    }
}