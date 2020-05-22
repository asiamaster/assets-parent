package com.dili.assets.service;

import java.util.List;
import java.util.Map;

import com.dili.assets.domain.CarTypePublic;
import com.dili.assets.domain.query.CarTypePublicQuery;
import com.dili.ss.base.BaseService;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-18 14:41:03.
 */
public interface CarTypePublicService extends BaseService<CarTypePublic, Long> {

	String listCarTypePublic(CarTypePublicQuery carTypePublic, boolean b) throws Exception;

	List<Map<String, Object>> getCarTypePublicById(CarTypePublicQuery carTypePublic);

	void updateCarTypePublic(CarTypePublic carTypePublic);

	void deleteTagExt(CarTypePublicQuery carTypePublic);
}