package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2020-05-25 16:10:36.
 */
@Table(name = "`bank`")
public class Bank extends BaseDomain {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 银行名称
     */
    @Column(name = "`name`")
    private String name;

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
     * 获取银行名称
     *
     * @return name - 银行名称
     */
    @FieldDef(label="银行名称", maxLength = 255)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getName() {
        return name;
    }

    /**
     * 设置银行名称
     *
     * @param name 银行名称
     */
    public void setName(String name) {
        this.name = name;
    }
}