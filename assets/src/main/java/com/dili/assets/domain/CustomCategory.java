package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2020-05-18 15:42:05.
 */
@Table(name = "`custom_category`")
public class CustomCategory extends BaseDomain {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`category`")
    private Long category;

    @Column(name = "`market_id`")
    private Long marketId;

    /**
     * 别名
     */
    @Column(name = "`cus_name`")
    private String cusName;

    /**
     * 快捷码
     */
    @Column(name = "`keycode`")
    private String keycode;

    @Column(name = "`state`")
    private Integer state;

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
     * @return category
     */
    @FieldDef(label="category")
    @EditMode(editor = FieldEditor.Number, required = true)
    public Long getCategory() {
        return category;
    }

    /**
     * @param category
     */
    public void setCategory(Long category) {
        this.category = category;
    }

    /**
     * @return market_id
     */
    @FieldDef(label="marketId")
    @EditMode(editor = FieldEditor.Number, required = true)
    public Long getMarketId() {
        return marketId;
    }

    /**
     * @param marketId
     */
    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    /**
     * 获取别名
     *
     * @return cus_name - 别名
     */
    @FieldDef(label="别名", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = true)
    public String getCusName() {
        return cusName;
    }

    /**
     * 设置别名
     *
     * @param cusName 别名
     */
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    /**
     * 获取快捷码
     *
     * @return keycode - 快捷码
     */
    @FieldDef(label="快捷码", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = true)
    public String getKeycode() {
        return keycode;
    }

    /**
     * 设置快捷码
     *
     * @param keycode 快捷码
     */
    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }

    /**
     * @return state
     */
    @FieldDef(label="state")
    @EditMode(editor = FieldEditor.Text, required = true)
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }
}