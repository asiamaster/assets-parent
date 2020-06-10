package com.dili.assets.mapper;

import java.util.List;
import java.util.Map;

import com.dili.assets.domain.CarTypePublic;
import com.dili.assets.domain.query.CarTypePublicQuery;
import com.dili.ss.base.MyMapper;

public interface CarTypePublicMapper extends MyMapper<CarTypePublic> {

	List<Map<String, Object>> listCarTypePublic(CarTypePublicQuery carTypePublic);

	List<Map<String, Object>> getCarTypePublicById(CarTypePublicQuery carTypePublic);

	void updateCarTypePublic(CarTypePublic carTypePublic);

	void deleteTagExt(CarTypePublicQuery carTypePublic);
}