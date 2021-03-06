package com.dili.assets.sdk.dto;

import com.dili.ss.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 由PD Man工具自动生成
 */
public class CategoryDTO extends BaseDomain{
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
     * 状态
     */
    private Integer isDelete;
    /**
     * 父品类
     */
    private Long parent;
    /**
     * 路劲
     */
    private String path;
    /**
     * icon
     */
    private String icon;
    /**
     * 编码
     */
    private String code;
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
    private Integer state ;

    /**
     * id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 品类名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 品类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 拼音
     */
    public String getPingying() {
        return this.pingying;
    }

    /**
     * 拼音
     */
    public void setPingying(String pingying) {
        this.pingying = pingying;
    }

    /**
     * 拼音缩写
     */
    public String getPyInitials() {
        return this.pyInitials;
    }

    /**
     * 拼音缩写
     */
    public void setPyInitials(String pyInitials) {
        this.pyInitials = pyInitials;
    }

    /**
     * 状态
     */
    public Integer getIsDelete() {
        return this.isDelete;
    }

    /**
     * 状态
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 父品类
     */
    public Long getParent() {
        return this.parent;
    }

    /**
     * 父品类
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }

    /**
     * 路劲
     */
    public String getPath() {
        return this.path;
    }

    /**
     * 路劲
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 编码
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 创建人
     */
    public Long getCreatorId() {
        return this.creatorId;
    }

    /**
     * 创建人
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getModifyTime() {
        return this.modifyTime;
    }

    /**
     * 更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 状态
     */
    public Integer getState(){
        return this.state;
    }
    /**
     * 状态
     */
    public void setState(Integer state){
        this.state = state;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 别名
     */

    private String cusName;

    /**
     * 快捷码
     */

    private String keycode;

    private List<String> ids;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }

    private Long marketId;

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}