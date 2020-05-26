package com.dili.assets.sdk.dto;

public enum CityLevelType {

	PROVINCE(1), CITY(2), DISTRICT(3);

	private CityLevelType(Integer value) {
		this.value = value;
	}

	private Integer value;

	public Integer getValue() {
		return value;
	}

}
