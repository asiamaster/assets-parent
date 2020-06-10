package com.dili.assets.sdk.dto;

public class BankUnionInfoDto {

	private Long id;

	/**
	 * 开户行名称
	 */
	private String bankName;

	/**
	 * 银联号
	 */
	private Long unionPayNumber;

	private Long bankId;

	/**
	 * 区
	 */
	private String district;

	/**
	 * 市
	 */
	private String city;

	/**
	 * 省
	 */
	private String province;

	/**
	 * 区id
	 */
	private Long districtId;

	/**
	 * 城市id
	 */
	private Long cityId;

	/**
	 * 省id
	 */
	private Long provinceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getUnionPayNumber() {
		return unionPayNumber;
	}

	public void setUnionPayNumber(Long unionPayNumber) {
		this.unionPayNumber = unionPayNumber;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

}
