package com.dili.assets.mapper.dynamic;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 市场品类 
 */
@Getter
@Setter
public class CusCategoryDO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 品类名称
     */
    private String name;

    /**
     * 拼音
     */
    private String pingying;

    /**
     * 拼音缩写
     */
    private String pyInitials;

    /**
     * 图标
     */
    private String icon;

    /**
     * 市场
     */
    private Long marketId;

    /**
     * 状态
     */
    private Integer delete;

    /**
     * 父品类
     */
    private Long parent;

    /**
     * 路劲
     */
    private String path;

    /**
     * 创建人
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime modifyTime;

    /**
     * 状态
     */
    private Byte state;

    /**
     * 快捷码
     */
    private String keycode;

    /**
     * 品类id
     */
    private Long categoryId;

    private static final long serialVersionUID = 1L;
}