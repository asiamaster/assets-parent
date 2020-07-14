package com.dili.assets.sdk.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CityDto {

	private Long id;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date created;

	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modified;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 父ID
	 */
	private Long parentId;

	/**
	 * 简称
	 */
	private String shortName;

	/**
	 * 级别
	 */
	private Integer levelType;

	/**
	 * 区号
	 */
	private String cityCode;

	/**
	 * 合并名称
	 */
	private String mergerName;

	private String lng;

	private String lat;

	/**
	 * 拼音
	 */
	private String pinyin;

	/**
	 * 拼音简写
	 */
	private String shortPy;

	/**
	 * 是否有效（1：有效 -1：无效）
	 */
	private Boolean yn;

	/**
	 * ID集查询
	 */
	private List<Long> idList;

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取创建时间
	 *
	 * @return CREATED - 创建时间
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * 设置创建时间
	 *
	 * @param created 创建时间
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * 获取修改时间
	 *
	 * @return MODIFIED - 修改时间
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * 设置修改时间
	 *
	 * @param modified 修改时间
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/**
	 * 获取名称
	 *
	 * @return name - 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 *
	 * @param name 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取父ID
	 *
	 * @return parent_id - 父ID
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置父ID
	 *
	 * @param parentId 父ID
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取简称
	 *
	 * @return short_name - 简称
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * 设置简称
	 *
	 * @param shortName 简称
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * 获取级别
	 *
	 * @return level_type - 级别
	 */
	public Integer getLevelType() {
		return levelType;
	}

	/**
	 * 设置级别
	 *
	 * @param levelType 级别
	 */
	public void setLevelType(Integer levelType) {
		this.levelType = levelType;
	}

	/**
	 * 获取区号
	 *
	 * @return city_code - 区号
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * 设置区号
	 *
	 * @param cityCode 区号
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * 获取合并名称
	 *
	 * @return merger_name - 合并名称
	 */
	public String getMergerName() {
		return mergerName;
	}

	/**
	 * 设置合并名称
	 *
	 * @param mergerName 合并名称
	 */
	public void setMergerName(String mergerName) {
		this.mergerName = mergerName;
	}

	/**
	 * @return lng
	 */
	public String getLng() {
		return lng;
	}

	/**
	 * @param lng
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}

	/**
	 * @return lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @param lat
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * 获取拼音
	 *
	 * @return pinyin - 拼音
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * 设置拼音
	 *
	 * @param pinyin 拼音
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	/**
	 * 获取拼音简写
	 *
	 * @return short_py - 拼音简写
	 */
	public String getShortPy() {
		return shortPy;
	}

	/**
	 * 设置拼音简写
	 *
	 * @param shortPy 拼音简写
	 */
	public void setShortPy(String shortPy) {
		this.shortPy = shortPy;
	}

	/**
	 * 获取是否有效（1：有效 -1：无效）
	 *
	 * @return yn - 是否有效（1：有效 -1：无效）
	 */
	public Boolean getYn() {
		return yn;
	}

	/**
	 * 设置是否有效（1：有效 -1：无效）
	 *
	 * @param yn 是否有效（1：有效 -1：无效）
	 */
	public void setYn(Boolean yn) {
		this.yn = yn;
	}

	public List<Long> getIdList() {
		return idList;
	}

	public void setIdList(List<Long> idList) {
		this.idList = idList;
	}
}
