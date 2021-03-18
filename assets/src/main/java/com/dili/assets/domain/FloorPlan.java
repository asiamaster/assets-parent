package com.dili.assets.domain;

import com.dili.ss.domain.BaseDomain;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * (FloorPlan)表实体类
 *
 * @author makejava
 * @since 2021-01-28 17:18:27
 */
@Entity
@Data
@Table(name = "floor_plan")
public class FloorPlan extends BaseDomain implements Serializable {
    /**
     * oid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * 类型：1背景图，2摊位图
     */
    @Column(name = "plan_type")
    private Integer planType;

    /**
     * 是否规则图形,1规则，2不规则
     */
    @Column(name = "is_irregular")
    private Integer isIrregular;
    /**
     * 不规则图形描点json串
     */
    @Column(name = "irregular_point")
    private String irregularPoint;
    /**
     * 是否删除，0正常1删除
     */
    @Column(name = "item_state")
    private Integer itemState;
    /**
     * 名称
     */
    @Column(name = "plan_name")
    private String planName;
    /**
     * 图片Url
     */
    @Column(name = "plan_url")
    private String planUrl;
    /**
     * 颜色
     */
    @Column(name = "plan_color")
    private String planColor;
    /**
     * 文本
     */
    @Column(name = "plan_text")
    private String planText;

    @Column(name = "plan_version")
    private Integer planVersion;
    /**
     * 摊位id
     */
    @Column(name = "booth_id")
    private Long boothId;
    /**
     * 摊位名称
     */
    @Column(name = "booth_name")
    private String boothName;
    /**
     * 摊位状态
     */
    @Column(name = "booth_state")
    private String boothState;
    /**
     * 租赁状态
     */
    @Column(name = "booth_rent_state")
    private String boothRentState;
    /**
     * 摊位图宽度
     */
    @Column(name = "item_width")
    private Integer itemWidth;
    /**
     * 摊位图高度
     */
    @Column(name = "item_height")
    private Integer itemHeight;
    /**
     * 摊位图x位置
     */
    @Column(name = "item_x_site")
    private Integer itemXSite;
    /**
     * 摊位图y位置
     */
    @Column(name = "item_y_site")
    private Integer itemYSite;
    /**
     * 创建人
     */
    @Column(name = "creator_id")
    private Long creatorId;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;


    /**
     * 上级所属id
     */
    @Column(name = "ref_id")
    private Long refId;

    /**
     * 区域id
     */
    @Column(name = "district_id")
    private Long districtId;
    /**
     * 更新备注
     */
    @Column(name = "update_notes")
    private String updateNotes;

    /**
     * 类别，1区域2摊位
     */
    @Column(name = "regional_category")
    private Integer regionalCategory;
    /**
     * 用于更新refId
     */
    @Transient
    private Long newRefId;

    public Integer getRegionalCategory() {
        return regionalCategory;
    }

    public void setRegionalCategory(Integer regionalCategory) {
        this.regionalCategory = regionalCategory;
    }

    public String getUpdateNotes() {
        return updateNotes;
    }

    public void setUpdateNotes(String updateNotes) {
        this.updateNotes = updateNotes;
    }

    public Long getNewRefId() {
        return newRefId;
    }

    public void setNewRefId(Long newRefId) {
        this.newRefId = newRefId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getRefId() {
        return refId;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
    }

    public Integer getPlanVersion() {
        return planVersion;
    }

    public void setPlanVersion(Integer planVersion) {
        this.planVersion = planVersion;
    }

    public Integer getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public Integer getIsIrregular() {
        return isIrregular;
    }

    public void setIsIrregular(Integer isIrregular) {
        this.isIrregular = isIrregular;
    }

    public String getIrregularPoint() {
        return irregularPoint;
    }

    public void setIrregularPoint(String irregularPoint) {
        this.irregularPoint = irregularPoint;
    }

    public Integer getItemState() {
        return itemState;
    }

    public void setItemState(Integer itemState) {
        this.itemState = itemState;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanUrl() {
        return planUrl;
    }

    public void setPlanUrl(String planUrl) {
        this.planUrl = planUrl;
    }

    public String getPlanColor() {
        return planColor;
    }

    public void setPlanColor(String planColor) {
        this.planColor = planColor;
    }

    public String getPlanText() {
        return planText;
    }

    public void setPlanText(String planText) {
        this.planText = planText;
    }

    public Long getBoothId() {
        return boothId;
    }

    public void setBoothId(Long boothId) {
        this.boothId = boothId;
    }

    public String getBoothName() {
        return boothName;
    }

    public void setBoothName(String boothName) {
        this.boothName = boothName;
    }

    public String getBoothState() {
        return boothState;
    }

    public void setBoothState(String boothState) {
        this.boothState = boothState;
    }

    public String getBoothRentState() {
        return boothRentState;
    }

    public void setBoothRentState(String boothRentState) {
        this.boothRentState = boothRentState;
    }

    public Integer getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(Integer itemWidth) {
        this.itemWidth = itemWidth;
    }

    public Integer getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(Integer itemHeight) {
        this.itemHeight = itemHeight;
    }

    public Integer getItemXSite() {
        return itemXSite;
    }

    public void setItemXSite(Integer itemXSite) {
        this.itemXSite = itemXSite;
    }

    public Integer getItemYSite() {
        return itemYSite;
    }

    public void setItemYSite(Integer itemYSite) {
        this.itemYSite = itemYSite;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}