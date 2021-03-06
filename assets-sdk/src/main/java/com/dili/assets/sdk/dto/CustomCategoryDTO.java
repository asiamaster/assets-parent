package com.dili.assets.sdk.dto;

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

public class CustomCategoryDTO extends BaseDomain {

    private Long id;

    private Long category;


    private Long marketId;

    /**
     * 别名
     */

    private String cusName;

    /**
     * 快捷码
     */

    private String keycode;


    private Integer state;

    /**
     * @return id
     */

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