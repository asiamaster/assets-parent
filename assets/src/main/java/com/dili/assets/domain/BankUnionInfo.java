package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2020-05-25 16:11:17.
 */
@Table(name = "`bank_union_info`")
public class BankUnionInfo extends BaseDomain {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 开户行名称
     */
    @Column(name = "`bank_name`")
    private String bankName;

    /**
     * 银联号
     */
    @Column(name = "`union_pay_number`")
    private Long unionPayNumber;

    @Column(name = "`bank_id`")
    private Long bankId;

    /**
     * 区
     */
    @Column(name = "`district`")
    private String district;

    /**
     * 市
     */
    @Column(name = "`city`")
    private String city;

    /**
     * 省
     */
    @Column(name = "`province`")
    private String province;

    /**
     * 区id
     */
    @Column(name = "`district_id`")
    private Long districtId;

    /**
     * 城市id
     */
    @Column(name = "`city_id`")
    private Long cityId;

    /**
     * 省id
     */
    @Column(name = "`province_id`")
    private Long provinceId;

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
     * 获取开户行名称
     *
     * @return bank_name - 开户行名称
     */
    @FieldDef(label="开户行名称", maxLength = 50)
    @EditMode(editor = FieldEditor.Text, required = true)
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置开户行名称
     *
     * @param bankName 开户行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取银联号
     *
     * @return union_pay_number - 银联号
     */
    @FieldDef(label="银联号")
    @EditMode(editor = FieldEditor.Number, required = true)
    public Long getUnionPayNumber() {
        return unionPayNumber;
    }

    /**
     * 设置银联号
     *
     * @param unionPayNumber 银联号
     */
    public void setUnionPayNumber(Long unionPayNumber) {
        this.unionPayNumber = unionPayNumber;
    }

    /**
     * @return bank_id
     */
    @FieldDef(label="bankId")
    @EditMode(editor = FieldEditor.Number, required = true)
    public Long getBankId() {
        return bankId;
    }

    /**
     * @param bankId
     */
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    /**
     * 获取区
     *
     * @return district - 区
     */
    @FieldDef(label="区", maxLength = 30)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getDistrict() {
        return district;
    }

    /**
     * 设置区
     *
     * @param district 区
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    @FieldDef(label="市", maxLength = 15)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    @FieldDef(label="省", maxLength = 15)
    @EditMode(editor = FieldEditor.Text, required = false)
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取区id
     *
     * @return district_id - 区id
     */
    @FieldDef(label="区id")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * 设置区id
     *
     * @param districtId 区id
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    /**
     * 获取城市id
     *
     * @return city_id - 城市id
     */
    @FieldDef(label="城市id")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置城市id
     *
     * @param cityId 城市id
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取省id
     *
     * @return province_id - 省id
     */
    @FieldDef(label="省id")
    @EditMode(editor = FieldEditor.Number, required = false)
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省id
     *
     * @param provinceId 省id
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
}