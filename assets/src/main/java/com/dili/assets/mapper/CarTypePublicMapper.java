package com.dili.assets.mapper;

import java.util.List;

import com.dili.assets.domain.CarTypePublic;
import com.dili.assets.domain.query.CarTypePublicQuery;
import com.dili.ss.base.MyMapper;

public interface CarTypePublicMapper extends MyMapper<CarTypePublic> {

	List<CarTypePublic> listCarTypePublic(CarTypePublicQuery carTypePublic);

	CarTypePublic getCarTypePublicById(Long id);

	void updateCarTypePublic(CarTypePublic carTypePublic);
}