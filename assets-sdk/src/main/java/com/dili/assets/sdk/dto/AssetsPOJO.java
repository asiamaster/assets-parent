package com.dili.assets.sdk.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class AssetsPOJO {
    /** id */
    @Id
    @Column(name = "`id`")
    private Long id ;
    /** 摊位名称 */
    @Column(name = "`name`")
    private String name ;
    /** 数量 */
    @Column(name = "`number`")
    private Double number ;
    /** 单位 */
    @Column(name = "`unit`")
    private String unit ;
    /** 区域 */
    @Column(name = "`area`")
    private Integer area ;
    /** 区域 */
    @Column(name = "`second_area`")
    private Integer secondArea ;
    /** 摊位类型 */
    @Column(name = "`type`")
    private Integer type ;
    /** 所属部门 */
    @Column(name = "`department_id`")
    private String departmentId ;
    /** 市场 */
    @Column(name = "`market_id`")
    private Long marketId ;
    /** 父摊位 */
    @Column(name = "`parent_id`")
    private Long parentId ;
    /** 备注 */
    @Column(name = "`notes`")
    private String notes ;
    /** 状态 */
    @Column(name = "`state`")
    private Integer state ;
    /** 租赁状态 */
    @Column(name = "`rent_state`")
    private Integer rentState ;
    /** 使用方 */
    @Column(name = "`user`")
    private String user ;
    /** 楼层 */
    @Column(name = "`floor`")
    private String floor ;
    /** 楼层 */
    @Column(name = "`floor_id`")
    private Long floorId ;
    /** 性质 */
    @Column(name = "`kind`")
    private Integer kind ;
    /** 是否转角 */
    @Column(name = "`corner`")
    private Integer corner ;
    /** 是否删除 */
    @Column(name = "`is_delete`")
    private Integer isDelete ;
    /** 拆分备注 */
    @Column(name = "`split_notes`")
    private String splitNotes ;
    /** 排序 */
    @Column(name = "`sort`")
    private String sort ;
    /** 创建人 */
    @Column(name = "`creator_id`")
    private Long creatorId ;
    /** 创建时间 */
    @Column(name = "`create_time`")
    private Date createTime ;
    /** 更新时间 */
    @Column(name = "`modify_time`")
    private Date modifyTime ;
    /** 业务类型;1:摊位，2:冷库，3:公寓 */
    @Column(name = "`business_type`")
    private Integer businessType ;

    /** id */
    public Long getId(){
        return this.id;
    }
    /** id */
    public void setId(Long id){
        this.id = id;
    }
    /** 摊位名称 */
    public String getName(){
        return this.name;
    }
    /** 摊位名称 */
    public void setName(String name){
        this.name = name;
    }
    /** 数量 */
    public Double getNumber(){
        return this.number;
    }
    /** 数量 */
    public void setNumber(Double number){
        this.number = number;
    }
    /** 单位 */
    public String getUnit(){
        return this.unit;
    }
    /** 单位 */
    public void setUnit(String unit){
        this.unit = unit;
    }
    /** 区域 */
    public Integer getArea(){
        return this.area;
    }
    /** 区域 */
    public void setArea(Integer area){
        this.area = area;
    }
    /** 区域 */
    public Integer getSecondArea(){
        return this.secondArea;
    }
    /** 区域 */
    public void setSecondArea(Integer secondArea){
        this.secondArea = secondArea;
    }
    /** 摊位类型 */
    public Integer getType(){
        return this.type;
    }
    /** 摊位类型 */
    public void setType(Integer type){
        this.type = type;
    }
    /** 所属部门 */
    public String getDepartmentId(){
        return this.departmentId;
    }
    /** 所属部门 */
    public void setDepartmentId(String departmentId){
        this.departmentId = departmentId;
    }
    /** 市场 */
    public Long getMarketId(){
        return this.marketId;
    }
    /** 市场 */
    public void setMarketId(Long marketId){
        this.marketId = marketId;
    }
    /** 父摊位 */
    public Long getParentId(){
        return this.parentId;
    }
    /** 父摊位 */
    public void setParentId(Long parentId){
        this.parentId = parentId;
    }
    /** 备注 */
    public String getNotes(){
        return this.notes;
    }
    /** 备注 */
    public void setNotes(String notes){
        this.notes = notes;
    }
    /** 状态 */
    public Integer getState(){
        return this.state;
    }
    /** 状态 */
    public void setState(Integer state){
        this.state = state;
    }
    /** 租赁状态 */
    public Integer getRentState(){
        return this.rentState;
    }
    /** 租赁状态 */
    public void setRentState(Integer rentState){
        this.rentState = rentState;
    }
    /** 使用方 */
    public String getUser(){
        return this.user;
    }
    /** 使用方 */
    public void setUser(String user){
        this.user = user;
    }
    /** 楼层 */
    public String getFloor(){
        return this.floor;
    }
    /** 楼层 */
    public void setFloor(String floor){
        this.floor = floor;
    }
    /** 性质 */
    public Integer getKind(){
        return this.kind;
    }
    /** 性质 */
    public void setKind(Integer kind){
        this.kind = kind;
    }
    /** 是否转角 */
    public Integer getCorner(){
        return this.corner;
    }
    /** 是否转角 */
    public void setCorner(Integer corner){
        this.corner = corner;
    }
    /** 是否删除 */
    public Integer getIsDelete(){
        return this.isDelete;
    }
    /** 是否删除 */
    public void setIsDelete(Integer isDelete){
        this.isDelete = isDelete;
    }
    /** 拆分备注 */
    public String getSplitNotes(){
        return this.splitNotes;
    }
    /** 拆分备注 */
    public void setSplitNotes(String splitNotes){
        this.splitNotes = splitNotes;
    }
    /** 排序 */
    public String getSort(){
        return this.sort;
    }
    /** 排序 */
    public void setSort(String sort){
        this.sort = sort;
    }
    /** 创建人 */
    public Long getCreatorId(){
        return this.creatorId;
    }
    /** 创建人 */
    public void setCreatorId(Long creatorId){
        this.creatorId = creatorId;
    }
    /** 创建时间 */
    public Date getCreateTime(){
        return this.createTime;
    }
    /** 创建时间 */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }
    /** 更新时间 */
    public Date getModifyTime(){
        return this.modifyTime;
    }
    /** 更新时间 */
    public void setModifyTime(Date modifyTime){
        this.modifyTime = modifyTime;
    }
    /** 业务类型;1:摊位，2:冷库，3:公寓 */
    public Integer getBusinessType(){
        return this.businessType;
    }
    /** 业务类型;1:摊位，2:冷库，3:公寓 */
    public void setBusinessType(Integer businessType){
        this.businessType = businessType;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }
}
