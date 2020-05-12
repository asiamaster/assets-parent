package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import java.util.Date;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 货车，注册车辆
 * This file was generated on 2020-05-12 10:33:52.
 */
@Table(name = "`truck`")
public class Truck extends BaseDomain {
    /**
     * id
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
     * 车牌号
     */
    @Column(name = "`plate`")
    private String plate;

    /**
     * 车型car_type的主键
     */
    @Column(name = "`car_type`")
    private Long carType;

    /**
     * 司机姓名
     */
    @Column(name = "`driver_name`")
    private String driverName;

    /**
     * 电话
     */
    @Column(name = "`driver_tel`")
    private String driverTel;

    /**
     * 重量
     */
    @Column(name = "`weight`")
    private Long weight;

    /**
     * 称重ID
     */
    @Column(name = "`weigh_id`")
    private Long weighId;

    @Column(name = "`rail_weigh_id`")
    private Long railWeighId;

    /**
     * 高栏重量
     */
    @Column(name = "`rail_weight`")
    private Long railWeight;

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

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    /**
     * 是否有效（1：有效 -1：无效）
     */
    @Column(name = "`yn`")
    private Boolean yn;

    @Column(name = "`car_type_name`")
    private String carTypeName;

    @Column(name = "`car_type_weight`")
    private Long carTypeWeight;

    /**
     * 0:无高栏，1：有高栏
     */
    @Column(name = "`hurdles`")
    private Byte hurdles;

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
     * 获取车牌号
     *
     * @return plate - 车牌号
     */
    @FieldDef(label="车牌号", maxLength = 10)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getPlate() {
        return plate;
    }

    /**
     * 设置车牌号
     *
     * @param plate 车牌号
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * 获取车型car_type的主键
     *
     * @return car_type - 车型car_type的主键
     */
    @FieldDef(label="车型car_type的主键")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getCarType() {
        return carType;
    }

    /**
     * 设置车型car_type的主键
     *
     * @param carType 车型car_type的主键
     */
    public void setCarType(Long carType) {
        this.carType = carType;
    }

    /**
     * 获取司机姓名
     *
     * @return driver_name - 司机姓名
     */
    @FieldDef(label="司机姓名", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getDriverName() {
        return driverName;
    }

    /**
     * 设置司机姓名
     *
     * @param driverName 司机姓名
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * 获取电话
     *
     * @return driver_tel - 电话
     */
    @FieldDef(label="电话", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getDriverTel() {
        return driverTel;
    }

    /**
     * 设置电话
     *
     * @param driverTel 电话
     */
    public void setDriverTel(String driverTel) {
        this.driverTel = driverTel;
    }

    /**
     * 获取重量
     *
     * @return weight - 重量
     */
    @FieldDef(label="重量")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getWeight() {
        return weight;
    }

    /**
     * 设置重量
     *
     * @param weight 重量
     */
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    /**
     * 获取称重ID
     *
     * @return weigh_id - 称重ID
     */
    @FieldDef(label="称重ID")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getWeighId() {
        return weighId;
    }

    /**
     * 设置称重ID
     *
     * @param weighId 称重ID
     */
    public void setWeighId(Long weighId) {
        this.weighId = weighId;
    }

    /**
     * @return rail_weigh_id
     */
    @FieldDef(label="railWeighId")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getRailWeighId() {
        return railWeighId;
    }

    /**
     * @param railWeighId
     */
    public void setRailWeighId(Long railWeighId) {
        this.railWeighId = railWeighId;
    }

    /**
     * 获取高栏重量
     *
     * @return rail_weight - 高栏重量
     */
    @FieldDef(label="高栏重量")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getRailWeight() {
        return railWeight;
    }

    /**
     * 设置高栏重量
     *
     * @param railWeight 高栏重量
     */
    public void setRailWeight(Long railWeight) {
        this.railWeight = railWeight;
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
     * 获取备注
     *
     * @return remark - 备注
     */
    @FieldDef(label="备注", maxLength = 50)
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

    /**
     * @return car_type_name
     */
    @FieldDef(label="carTypeName", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getCarTypeName() {
        return carTypeName;
    }

    /**
     * @param carTypeName
     */
    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }

    /**
     * @return car_type_weight
     */
    @FieldDef(label="carTypeWeight")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getCarTypeWeight() {
        return carTypeWeight;
    }

    /**
     * @param carTypeWeight
     */
    public void setCarTypeWeight(Long carTypeWeight) {
        this.carTypeWeight = carTypeWeight;
    }

    /**
     * 获取0:无高栏，1：有高栏
     *
     * @return hurdles - 0:无高栏，1：有高栏
     */
    @FieldDef(label="0:无高栏，1：有高栏")
    @EditMode(editor = FieldEditor.Text, required = false)
    public Byte getHurdles() {
        return hurdles;
    }

    /**
     * 设置0:无高栏，1：有高栏
     *
     * @param hurdles 0:无高栏，1：有高栏
     */
    public void setHurdles(Byte hurdles) {
        this.hurdles = hurdles;
    }
}