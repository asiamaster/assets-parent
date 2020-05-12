package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import java.util.Date;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 部门车型关系
 * This file was generated on 2020-05-12 10:33:30.
 */
@Table(name = "`department_car_type`")
public class DepartmentCarType extends BaseDomain {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门ID
     */
    @Column(name = "`department_id`")
    private Long departmentId;

    /**
     * 车型ID
     */
    @Column(name = "`car_type_id`")
    private Long carTypeId;

    /**
     * 操作员
     */
    @Column(name = "`operator_id`")
    private Long operatorId;

    /**
     * 操作员姓名
     */
    @Column(name = "`operator_name`")
    private String operatorName;

    @Column(name = "`CREATED`")
    private Date created;

    @Column(name = "`MODIFIED`")
    private Date modified;

    /**
     * 1:有效：0无效
     */
    @Column(name = "`yn`")
    private Byte yn;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

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
     * 获取部门ID
     *
     * @return department_id - 部门ID
     */
    @FieldDef(label="部门ID")
    @EditMode(editor = FieldEditor.Number, required = true)
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置部门ID
     *
     * @param departmentId 部门ID
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取车型ID
     *
     * @return car_type_id - 车型ID
     */
    @FieldDef(label="车型ID")
    @EditMode(editor = FieldEditor.Number, required = true)
    public Long getCarTypeId() {
        return carTypeId;
    }

    /**
     * 设置车型ID
     *
     * @param carTypeId 车型ID
     */
    public void setCarTypeId(Long carTypeId) {
        this.carTypeId = carTypeId;
    }

    /**
     * 获取操作员
     *
     * @return operator_id - 操作员
     */
    @FieldDef(label="操作员")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getOperatorId() {
        return operatorId;
    }

    /**
     * 设置操作员
     *
     * @param operatorId 操作员
     */
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取操作员姓名
     *
     * @return operator_name - 操作员姓名
     */
    @FieldDef(label="操作员姓名", maxLength = 20)
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
     * @return CREATED
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
     * @return MODIFIED
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

    /**
     * 获取1:有效：0无效
     *
     * @return yn - 1:有效：0无效
     */
    @FieldDef(label="1:有效：0无效")
    @EditMode(editor = FieldEditor.Text, required = false)
    public Byte getYn() {
        return yn;
    }

    /**
     * 设置1:有效：0无效
     *
     * @param yn 1:有效：0无效
     */
    public void setYn(Byte yn) {
        this.yn = yn;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    @FieldDef(label="备注", maxLength = 255)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}