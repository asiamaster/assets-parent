package com.dili.assets.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.dili.ss.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 由MyBatis Generator工具自动生成
 * 市场内业务对应的收费项信息
 * This file was generated on 2020-05-28 17:14:10.
 */
@Getter
@Setter
@ToString(callSuper = true)
@Table(name = "`business_charge_item`")
public class BusinessChargeItem extends BaseDomain {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父项目ID,本项目的关联费用项
     */
    @Column(name = "`parent_id`")
    private Long parentId;

    /**
     * 所属市场
     */
    @Column(name = "`market_id`")
    @NotNull(message = "所属市场不能为空")
    private Long marketId;

    /**
     * 所属业务
     */
    @Column(name = "`business_type`")
    @NotNull(message = "所属业务不能为空")
    private String businessType;

    /**
     * 所属费用项
     */
    @Column(name = "`charge_item`")
    @NotBlank(message = "费用项名称不能为空")
    private String chargeItem;

    /**
     * 所属费用项
     */
    @Column(name = "`charge_type`")
    @NotNull(message = "费用项类型不能为空")
    private Integer chargeType;

    /**
     * 资金项目
     */
    @Column(name = "`fund_item`")
    @NotBlank(message = "资金项目不能为空")
    private Long fundItem;

    /**
     * 资金项目
     */
    @Column(name = "`fund_item_value`")
    @NotBlank(message = "关联资金项目值不能为空")
    private String fundItemValue;

    /**
     * 费用项编码
     */
    @Column(name = "`code`")
    @Size(max = 20,message = "费用项编码请保持在20个字符以内")
    private String code;

    /**
     * 是否为固定项
     * {@link com.dili.commons.glossary.YesOrNoEnum}
     */
    @Column(name = "`fixed`")
    @NotNull(message = "是否固定项不能为空")
    private Integer fixed;

    /**
     * 是否为必填项
     */
    @Column(name = "`is_required`")
    @NotNull(message = "是否必填项不能为空")
    private Integer isRequired;

    /**
     * 是否启用
     */
    @Column(name = "`is_enable`")
    private Integer isEnable;

    /**
     * 是否删除
     */
    @Column(name = "`is_delete`")
    private Integer isDelete;

    /**
     * 系统科目
     */
    @Column(name = "`system_subject`")
    private Integer systemSubject;

    /**
     * 财务费用科目路径,以逗号分隔
     */
    @Column(name = "`charge_subject_path`")
    private String chargeSubjectPath;

    /**
     * 财务费用科目名称
     */
    @Column(name = "`charge_subject_name`")
    private String chargeSubjectName;

    /**
     * 备注
     */
    @Column(name = "`notes`")
    @Size(max = 255, message = "备注请保持在255个字符以内")
    private String notes;

    /**
     * 创建人
     */
    @Column(name = "`operator_id`")
    private Long operatorId;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @Column(name = "`modify_time`")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;

}