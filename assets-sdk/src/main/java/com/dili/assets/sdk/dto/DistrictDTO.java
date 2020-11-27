package com.dili.assets.sdk.dto;

import com.dili.ss.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * 区域 ;
 * This file was generated on 2020-02-17 11:17:18.
 */
@Data
public class DistrictDTO extends BaseDomain {
    /**
     * id
     */
    private Long id;
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
     * 区域名称
     */
    private String name;
    /**
     * 备注
     */
    private String notes;
    /**
     * 部门
     */
    private Long departmentId;
    /**
     * 负责人
     */
    private Long owner;
    /**
     * 市场
     */
    private Long marketId;
    /**
     * 父区域
     */
    private Long parentId;

    /**
     * 编号
     */
    private String number;
    /**
     * 状态
     */
    private Integer isDelete;

    private String deps;


    private String nameLike;


    private List<String> ids;

    private String parentName;

    private Integer kind;
}