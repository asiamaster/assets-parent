package com.dili.assets.mapper;

import java.util.List;
import java.util.Map;

import com.dili.assets.domain.CarTypePublic;
import com.dili.assets.domain.query.CarTypePublicQuery;
import com.dili.assets.sdk.dto.CarTypeForBusinessDTO;
import com.dili.ss.base.MyMapper;

public interface CarTypePublicMapper extends MyMapper<CarTypePublic> {

	List<Map<String, Object>> listCarTypePublic(CarTypePublicQuery carTypePublic);

	List<Map<String, Object>> getCarTypePublicById(CarTypePublicQuery carTypePublic);

	void updateCarTypePublic(CarTypePublic carTypePublic);

	void deleteTagExt(CarTypePublicQuery carTypePublic);

	List<CarTypeForBusinessDTO> listCarTypePublicByBusiness(CarTypePublicQuery carTypePublic);

	List<CarTypeForBusinessDTO> queryCarType(CarTypePublicQuery carTypePublic);

	List<CarTypePublic> checkRepeat(CarTypePublic carTypePublic);

	void updateStatusByCarTypeId(CarTypePublic carTypePublic);

}