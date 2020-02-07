package com.dili.assets.domain;

import com.dili.ss.dto.IBaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 由MyBatis Generator工具自动生成
 * 品类 ;
 * This file was generated on 2020-02-05 12:37:16.
 */
@Table(name = "`category`")
public interface Category extends IBaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @FieldDef(label="id")
    @EditMode(editor = FieldEditor.Number, required = true)
    Long getId();

    void setId(Long id);

    @Column(name = "`name`")
    @FieldDef(label="品类名称", maxLength = 32)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getName();

    void setName(String name);

    @Column(name = "`pingying`")
    @FieldDef(label="拼音", maxLength = 32)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getPingying();

    void setPingying(String pingying);

    @Column(name = "`py_initials`")
    @FieldDef(label="拼音缩写", maxLength = 32)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getPyInitials();

    void setPyInitials(String pyInitials);

    @Column(name = "`status`")
    @FieldDef(label="状态", maxLength = 32)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getStatus();

    void setStatus(String status);

    @Column(name = "`parent`")
    @FieldDef(label="父品类")
    @EditMode(editor = FieldEditor.Number, required = false)
    Long getParent();

    void setParent(Long parent);

    @Column(name = "`path`")
    @FieldDef(label="路劲", maxLength = 32)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getPath();

    void setPath(String path);

    @Column(name = "`code`")
    @FieldDef(label="编码", maxLength = 32)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getCode();

    void setCode(String code);

    @Column(name = "`creator_id`")
    @FieldDef(label="创建人")
    @EditMode(editor = FieldEditor.Number, required = false)
    Long getCreatorId();

    void setCreatorId(Long creatorId);

    @Column(name = "`create_time`")
    @FieldDef(label="创建时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    Date getCreateTime();

    void setCreateTime(Date createTime);

    @Column(name = "`modify_time`")
    @FieldDef(label="更新时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    Date getModifyTime();

    void setModifyTime(Date modifyTime);
}