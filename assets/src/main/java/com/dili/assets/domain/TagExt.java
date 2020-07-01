package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2020-05-22 09:17:48.
 */
@Table(name = "`tag_ext`")
public class TagExt extends BaseDomain {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`code`")
    private String code;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`weight`")
    private Long weight;

    @Column(name = "`car_type_public_id`")
    private Long carTypePublicId;

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
     * @return code
     */
    @FieldDef(label="code", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = true)
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
    @FieldDef(label="name", maxLength = 50)
    @EditMode(editor = FieldEditor.Text, required = true)
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
    @FieldDef(label="weight")
    @EditMode(editor = FieldEditor.Number, required = false)
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
    @FieldDef(label="carTypePublicId")
    @EditMode(editor = FieldEditor.Number, required = true)
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