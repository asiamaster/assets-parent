package com.dili.assets.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.dili.ss.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
     * 所属市场
     */
    @Column(name = "`market_id`")
    @NotNull(message = "所属市场不能为空")
    private Long marketId;

    /**
     * 所属业务
     */
    @Column(name = "`business_id`")
    @NotNull(message = "所属业务不能为空")
    private Long businessId;

    /**
     * 所属费用项
     */
    @Column(name = "`charge_item`")
    @NotNull(message = "费用项不能为空")
    private Long chargeItem;

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