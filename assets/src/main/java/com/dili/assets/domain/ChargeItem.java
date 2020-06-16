package com.dili.assets.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.dili.ss.domain.BaseDomain;
import com.dili.ss.domain.annotation.Like;
import com.dili.ss.domain.annotation.Operator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <B></B>
 * <B>Copyright:本软件源代码版权归农丰时代科技有限公司及其研发团队所有,未经许可不得任意复制与传播.</B>
 * <B>农丰时代科技有限公司</B>
 *
 * @author yuehongbo
 * @date 2020/5/27 15:34
 */
@Getter
@Setter
@ToString(callSuper = true)
@Table(name = "`charge_item`")
public class ChargeItem extends BaseDomain {

    /**
     * 主键ID
     */
    @Id
    @Column(name = "`id`",updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 收费项名称
     */
    @Column(name = "`name`")
    @Like
    @NotBlank(message = "收费项名称不能为空")
    @Size(max = 50, message = "收费项名称请保持在50个字符以内")
    private String name;

    /**
     * 是否启用
     * @see com.dili.commons.glossary.YesOrNoEnum
     */
    @Column(name = "`is_enable`")
    private Integer isEnable;

    /**
     * 是否删除
     * {@link com.dili.commons.glossary.YesOrNoEnum}
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
    @Column(name = "`create_time`",updatable = false)
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

    /**
     * 辅助字段，根据ID集进行查询
     */
    @Transient
    @Operator(Operator.IN)
    @Column(name = "`id`")
    private List<Long> idList;

    /**
     * 在某业务中，是否为必填项
     * 该字段为 业务-费用项 中的字段
     */
    @Transient
    private Integer isRequired;
}
