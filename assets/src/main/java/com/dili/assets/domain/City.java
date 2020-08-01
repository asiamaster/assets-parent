package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.domain.annotation.Like;
import com.dili.ss.domain.annotation.Operator;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2020-05-21 15:27:39.
 */
@Table(name = "`city`")
public class City extends BaseDomain {
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
     * 名称
     */
    @Column(name = "`name`")
    @Like
    private String name;

    /**
     * 父ID
     */
    @Column(name = "`parent_id`")
    private Long parentId;

    /**
     * 简称
     */
    @Column(name = "`short_name`")
    @Like
    private String shortName;

    /**
     * 级别
     */
    @Column(name = "`level_type`")
    private Integer levelType;

    /**
     * 区号
     */
    @Column(name = "`city_code`")
    private String cityCode;

    /**
     * 合并名称
     */
    @Column(name = "`merger_name`")
    @Like
    private String mergerName;

    @Column(name = "`lng`")
    private String lng;

    @Column(name = "`lat`")
    private String lat;

    /**
     * 拼音
     */
    @Column(name = "`pinyin`")
    @Like
    private String pinyin;

    /**
     * 拼音简写
     */
    @Column(name = "`short_py`")
    private String shortPy;

    /**
     * 是否有效（1：有效 -1：无效）
     */
    @Column(name = "`yn`")
    private Boolean yn;

    /**
     * 根据ID集合查询
     */
    @Transient
    @Column(name = "`id`")
    @Operator(Operator.IN)
    private List<Long> idList;

    /**
     * 级别集合查询
     */
    @Transient
    @Column(name = "`level_type`")
    @Operator(Operator.IN)
    private List<Integer> levelTypeList;

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
     * 获取父ID
     *
     * @return parent_id - 父ID
     */
    @FieldDef(label="父ID")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父ID
     *
     * @param parentId 父ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取简称
     *
     * @return short_name - 简称
     */
    @FieldDef(label="简称", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置简称
     *
     * @param shortName 简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 获取级别
     *
     * @return level_type - 级别
     */
    @FieldDef(label="级别")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Integer getLevelType() {
        return levelType;
    }

    /**
     * 设置级别
     *
     * @param levelType 级别
     */
    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }

    /**
     * 获取区号
     *
     * @return city_code - 区号
     */
    @FieldDef(label="区号", maxLength = 10)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置区号
     *
     * @param cityCode 区号
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * 获取合并名称
     *
     * @return merger_name - 合并名称
     */
    @FieldDef(label="合并名称", maxLength = 50)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getMergerName() {
        return mergerName;
    }

    /**
     * 设置合并名称
     *
     * @param mergerName 合并名称
     */
    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }

    /**
     * @return lng
     */
    @FieldDef(label="lng", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getLng() {
        return lng;
    }

    /**
     * @param lng
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * @return lat
     */
    @FieldDef(label="lat", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getLat() {
        return lat;
    }

    /**
     * @param lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 获取拼音
     *
     * @return pinyin - 拼音
     */
    @FieldDef(label="拼音", maxLength = 40)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getPinyin() {
        return pinyin;
    }

    /**
     * 设置拼音
     *
     * @param pinyin 拼音
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    /**
     * 获取拼音简写
     *
     * @return short_py - 拼音简写
     */
    @FieldDef(label="拼音简写", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getShortPy() {
        return shortPy;
    }

    /**
     * 设置拼音简写
     *
     * @param shortPy 拼音简写
     */
    public void setShortPy(String shortPy) {
        this.shortPy = shortPy;
    }

    /**
     * 获取是否有效（1：有效 -1：无效）
     *
     * @return yn - 是否有效（1：有效 -1：无效）
     */
    @FieldDef(label="是否有效（1：有效 -1：无效）")
    @EditMode(editor = FieldEditor.Number, required = true)
    public Boolean getYn() {
        return yn;
    }

    /**
     * 设置是否有效（1：有效 -1：无效）
     *
     * @param yn 是否有效（1：有效 -1：无效）
     */
    public void setYn(Boolean yn) {
        this.yn = yn;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<Integer> getLevelTypeList() {
        return levelTypeList;
    }
    public void setLevelTypeList(List<Integer> levelTypeList) {
        this.levelTypeList = levelTypeList;
    }
}