package com.dili.assets.sdk.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 由MyBatis Generator工具自动生成
 * 摊位 ;
 * This file was generated on 2020-02-17 13:21:57.
 */
public class DepartmentCarTypeDTO extends BaseDomain {
    private Long id;

    /**
     * 部门ID
     */
    private Long departmentId;

    /**
     * 车型ID
     */
    private Long carTypeId;
    
    private List<Long> carTypeIds=new ArrayList<>();

    /**
     * 操作员
     */
    private Long operatorId;

    /**
     * 操作员姓名
     */
    private String operatorName;
    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;
    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modified;

    /**
     * 1:有效：0无效
     */
    private Integer yn;

    /**
     * 备注
     */
    private String remark;

    /**
     * @return id
     */
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
    public Integer getYn() {
        return yn;
    }

    /**
     * 设置1:有效：0无效
     *
     * @param yn 1:有效：0无效
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
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

	public List<Long> getCarTypeIds() {
		return carTypeIds;
	}

	public void setCarTypeIds(List<Long> carTypeIds) {
		this.carTypeIds = carTypeIds;
	}
}