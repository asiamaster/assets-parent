package com.dili.assets.sdk.dto;

import javax.persistence.Table;

import com.dili.ss.domain.BaseDomain;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2020-05-22 09:17:48.
 */
@Table(name = "`tag_ext`")
public class TagExtDTO extends BaseDomain {
    private Long id;

    private String code;

    private String name;

    private Long weight;

    private Long carTypePublicId;

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
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return weight
     */
    public Long getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    /**
     * @return car_type_public_id
     */
    public Long getCarTypePublicId() {
        return carTypePublicId;
    }

    /**
     * @param carTypePublicId
     */
    public void setCarTypePublicId(Long carTypePublicId) {
        this.carTypePublicId = carTypePublicId;
    }
}