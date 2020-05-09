package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import java.util.Date;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 车型业务类型
 * This file was generated on 2020-05-09 17:43:57.
 */
@Table(name = "`ctype_to_btype`")
public class CtypeToBtype extends BaseDomain {
    /**
     * id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 车型类型
     */
    @Column(name = "`car_type_id`")
    private Long carTypeId;

    /**
     * 业务类型
     */
    @Column(name = "`biz_type_id`")
    private Long bizTypeId;

    /**
     * 皮重
     */
    @Column(name = "`weight`")
    private Long weight;

    /**
     * 是否自动放行 1
     */
    @Column(name = "`auto_release`")
    private Integer autoRelease;

    /**
     * 是否自动存储 1
     */
    @Column(name = "`auto_save`")
    private Integer autoSave;

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
     * 获取车型类型
     *
     * @return car_type_id - 车型类型
     */
    @FieldDef(label="车型类型")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getCarTypeId() {
        return carTypeId;
    }

    /**
     * 设置车型类型
     *
     * @param carTypeId 车型类型
     */
    public void setCarTypeId(Long carTypeId) {
        this.carTypeId = carTypeId;
    }

    /**
     * 获取业务类型
     *
     * @return biz_type_id - 业务类型
     */
    @FieldDef(label="业务类型")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getBizTypeId() {
        return bizTypeId;
    }

    /**
     * 设置业务类型
     *
     * @param bizTypeId 业务类型
     */
    public void setBizTypeId(Long bizTypeId) {
        this.bizTypeId = bizTypeId;
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
     * 获取是否自动放行 1
     *
     * @return auto_release - 是否自动放行 1
     */
    @FieldDef(label="是否自动放行 1")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Integer getAutoRelease() {
        return autoRelease;
    }

    /**
     * 设置是否自动放行 1
     *
     * @param autoRelease 是否自动放行 1
     */
    public void setAutoRelease(Integer autoRelease) {
        this.autoRelease = autoRelease;
    }

    /**
     * 获取是否自动存储 1
     *
     * @return auto_save - 是否自动存储 1
     */
    @FieldDef(label="是否自动存储 1")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Integer getAutoSave() {
        return autoSave;
    }

    /**
     * 设置是否自动存储 1
     *
     * @param autoSave 是否自动存储 1
     */
    public void setAutoSave(Integer autoSave) {
        this.autoSave = autoSave;
    }
}