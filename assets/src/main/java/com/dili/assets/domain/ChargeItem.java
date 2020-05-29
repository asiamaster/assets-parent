package com.dili.assets.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.dili.ss.domain.BaseDomain;
import com.dili.ss.domain.annotation.Like;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

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
}
