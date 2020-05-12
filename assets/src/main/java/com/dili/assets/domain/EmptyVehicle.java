package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import java.util.Date;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 空车车辆
 * This file was generated on 2020-05-12 10:34:12.
 */
@Table(name = "`empty_vehicle`")
public class EmptyVehicle extends BaseDomain {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 市场
     */
    @Column(name = "`market_id`")
    private Long marketId;

    /**
     * 车型
     */
    @Column(name = "`vehicle_type_id`")
    private Long vehicleTypeId;

    /**
     * 车牌号
     */
    @Column(name = "`plate_number`")
    private String plateNumber;

    /**
     * 图片
     */
    @Column(name = "`image_list`")
    private String imageList;

    /**
     * 操作人id
     */
    @Column(name = "`operator_id`")
    private Long operatorId;

    /**
     * 操作人姓名
     */
    @Column(name = "`operator_name`")
    private String operatorName;

    /**
     * 状态(1-整除，2-删除)
     */
    @Column(name = "`yn`")
    private Integer yn;

    /**
     * 创建时间
     */
    @Column(name = "`created`")
    private Date created;

    /**
     * 修改时间
     */
    @Column(name = "`modified`")
    private Date modified;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    @FieldDef(label="主键id")
    @EditMode(editor = FieldEditor.Number, required = true)
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取市场
     *
     * @return market_id - 市场
     */
    @FieldDef(label="市场")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getMarketId() {
        return marketId;
    }

    /**
     * 设置市场
     *
     * @param marketId 市场
     */
    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    /**
     * 获取车型
     *
     * @return vehicle_type_id - 车型
     */
    @FieldDef(label="车型")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getVehicleTypeId() {
        return vehicleTypeId;
    }

    /**
     * 设置车型
     *
     * @param vehicleTypeId 车型
     */
    public void setVehicleTypeId(Long vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    /**
     * 获取车牌号
     *
     * @return plate_number - 车牌号
     */
    @FieldDef(label="车牌号", maxLength = 10)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * 设置车牌号
     *
     * @param plateNumber 车牌号
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * 获取图片
     *
     * @return image_list - 图片
     */
    @FieldDef(label="图片", maxLength = 600)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getImageList() {
        return imageList;
    }

    /**
     * 设置图片
     *
     * @param imageList 图片
     */
    public void setImageList(String imageList) {
        this.imageList = imageList;
    }

    /**
     * 获取操作人id
     *
     * @return operator_id - 操作人id
     */
    @FieldDef(label="操作人id")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getOperatorId() {
        return operatorId;
    }

    /**
     * 设置操作人id
     *
     * @param operatorId 操作人id
     */
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取操作人姓名
     *
     * @return operator_name - 操作人姓名
     */
    @FieldDef(label="操作人姓名", maxLength = 50)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置操作人姓名
     *
     * @param operatorName 操作人姓名
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * 获取状态(1-整除，2-删除)
     *
     * @return yn - 状态(1-整除，2-删除)
     */
    @FieldDef(label="状态(1-整除，2-删除)")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Integer getYn() {
        return yn;
    }

    /**
     * 设置状态(1-整除，2-删除)
     *
     * @param yn 状态(1-整除，2-删除)
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    @FieldDef(label="创建时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
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
     * @return modified - 修改时间
     */
    @FieldDef(label="修改时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
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
}