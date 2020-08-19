package com.dili.assets.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dili.assets.domain.CarTypePublic;
import com.dili.assets.domain.query.CarTypePublicQuery;
import com.dili.assets.mapper.CarTypePublicMapper;
import com.dili.assets.sdk.dto.CarTypeForBusinessDTO;
import com.dili.assets.service.CarTypePublicService;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.domain.EasyuiPageOutput;
import com.dili.ss.metadata.ValueProviderUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-18 14:41:03.
 */
@Service
public class CarTypePublicServiceImpl extends BaseServiceImpl<CarTypePublic, Long> implements CarTypePublicService {

    public CarTypePublicMapper getActualDao() {
        return (CarTypePublicMapper)getDao();
    }

	@Override
	public List<Map<String, Object>> listCarTypePublic(CarTypePublicQuery carTypePublic, boolean b) throws Exception {
		List<Map<String, Object>> list = getActualDao().listCarTypePublic(carTypePublic);
		return list;
	}
	@Override
	public List<Map<String, Object>> listCarTypePublicByTruck(CarTypePublicQuery carTypePublic){
		
		List<Map<String, Object>> list = getActualDao().listCarTypePublic(carTypePublic);
		return list;
	}

	@Override
	public List<Map<String, Object>> getCarTypePublicById(CarTypePublicQuery carTypePublic) {
		return getActualDao().getCarTypePublicById(carTypePublic);
	}

	@Override
	public void updateCarTypePublic(CarTypePublic carTypePublic) {
		getActualDao().updateCarTypePublic(carTypePublic);
	}

	@Override
	public void deleteTagExt(CarTypePublicQuery carTypePublic) {
		getActualDao().deleteTagExt(carTypePublic);
	}

	@Override
	public List<CarTypeForBusinessDTO> listCarTypePublicByBusiness(CarTypePublicQuery carTypePublic) {
		return getActualDao().listCarTypePublicByBusiness(carTypePublic);
	}
	
	@Override
	public List<CarTypeForBusinessDTO> queryCarType(CarTypePublicQuery carTypePublic) {
		return getActualDao().queryCarType(carTypePublic);
	}

	@Override
	public List<CarTypePublic> checkRepeat(CarTypePublic carTypePublic) {
		return getActualDao().checkRepeat(carTypePublic);
	}

}