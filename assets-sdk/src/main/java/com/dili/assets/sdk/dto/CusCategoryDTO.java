package com.dili.assets.sdk.dto;

import com.dili.ss.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * 由PD Man工具自动生成
 * 品类 ;
 * This file was generated on 2020-02-05 12:37:16.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CusCategoryDTO extends BaseDomain {
    /**
     * 品类名称
     */
    private String name;
    /**
     * 别名
     */
    private String alias;
    /**
     * 拼音
     */
    private String pingying;
    /**
     * 拼音缩写
     */
    private String pyInitials;

    /**
     * 拼音缩写
     */
    private String icon;

    /**
     * 市场
     */
    private Long marketId;

    /**
     * 父品类
     */
    private Long parent;
    /**
     * 路劲
     */
    private String path;
    /**
     * 快捷码
     */
    private String keycode;
    /**
     * 创建人
     */
    private Long creatorId;
    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 集团品类
     */
    private Long categoryId;

}
