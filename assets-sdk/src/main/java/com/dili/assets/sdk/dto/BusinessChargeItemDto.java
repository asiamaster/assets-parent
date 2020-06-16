package com.dili.assets.sdk.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dili.ss.domain.BaseDomain;
import com.google.common.base.MoreObjects;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * <B></B>
 * <B>Copyright:本软件源代码版权归农丰时代科技有限公司及其研发团队所有,未经许可不得任意复制与传播.</B>
 * <B>农丰时代科技有限公司</B>
 *
 * @author yuehongbo
 * @date 2020/5/28 17:19
 */
public class BusinessChargeItemDto extends BaseDomain {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 所属市场
     */
    private Long marketId;

    /**
     * 所属业务
     */
    private String businessType;

    /**
     * 所属费用项
     */
    private Long chargeItem;

    /**
     * 是否为必填项
     * {@link com.dili.commons.glossary.YesOrNoEnum}
     */
    private Integer isRequired;

    /**
     * 是否启用
     * {@link com.dili.commons.glossary.YesOrNoEnum}
     */
    private Integer isEnable;

    /**
     * 是否删除
     * {@link com.dili.commons.glossary.YesOrNoEnum}
     */
    private Integer isDelete;

    /**
     * 备注
     */
    private String notes;

    /**
     * 创建人
     */
    private Long operatorId;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Long getChargeItem() {
        return chargeItem;
    }

    public void setChargeItem(Long chargeItem) {
        this.chargeItem = chargeItem;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("marketId", marketId)
                .add("businessType", businessType)
                .add("isRequired", isRequired)
                .add("isEnable", isEnable)
                .add("isDelete", isDelete)
                .add("notes", notes)
                .add("operatorId", operatorId)
                .add("createTime", createTime)
                .add("modifyTime", modifyTime)
                .toString();
    }
}
