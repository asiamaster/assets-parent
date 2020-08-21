package com.dili.assets.sdk.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dili.ss.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <B></B>
 * <B>Copyright:本软件源代码版权归农丰时代科技有限公司及其研发团队所有,未经许可不得任意复制与传播.</B>
 * <B>农丰时代科技有限公司</B>
 *
 * @author yuehongbo
 * @date 2020/5/28 17:19
 */
@Data
public class BusinessChargeItemDto extends BaseDomain {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 父项目ID,本项目的关联费用项
     */
    private Long parentId;

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
    private String chargeItem;

    /**
     * 费用项类型
     * {@link com.dili.assets.sdk.enums.BusinessChargeItemEnum.ChargeType}
     */
    private Integer chargeType;

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
     * 系统科目
     */
    private Integer systemSubject;

    /**
     * 财务费用科目
     */
    private String chargeSubjectPath;

    /**
     * 财务费用科目名称
     */
    private String chargeSubjectName;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;

    /**
     * ID数据集，可用于根据ID集合查询数据信息
     */
    private List<Long> idList;

}
