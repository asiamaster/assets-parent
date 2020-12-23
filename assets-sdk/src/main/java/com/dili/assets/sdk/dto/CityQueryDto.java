package com.dili.assets.sdk.dto;

import java.util.List;

import javax.persistence.Column;

import com.dili.ss.domain.annotation.Like;
import com.dili.ss.domain.annotation.Operator;

public class CityQueryDto extends CityDto {

	/**
	 * 根据ID集合查询
	 */
	@Column(name = "`id`")
	@Operator(Operator.IN)
	private List<Long> idList;

	/**
	 * 级别集合查询
	 */
	@Column(name = "`level_type`")
	@Operator(Operator.IN)
	private List<Integer> levelTypeList;

	@Column(name = "`name`")
	@Like
	private String keyword;

	public List<Long> getIdList() {
		return idList;
	}

	public void setIdList(List<Long> idList) {
		this.idList = idList;
	}

	public List<Integer> getLevelTypeList() {
		return levelTypeList;
	}

	public void setLevelTypeList(List<Integer> levelTypeList) {
		this.levelTypeList = levelTypeList;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
