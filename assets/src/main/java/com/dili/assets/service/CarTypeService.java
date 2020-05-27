package com.dili.assets.service;

import java.util.List;

import com.dili.assets.domain.CarType;
import com.dili.assets.domain.CarTypePublic;
import com.dili.ss.base.BaseService;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-09 16:44:34.
 */
public interface CarTypeService extends BaseService<CarType, Long> {

	void insertCarType(CarType carType);

	List<CarType> listCarType(CarTypePublic carType);

}