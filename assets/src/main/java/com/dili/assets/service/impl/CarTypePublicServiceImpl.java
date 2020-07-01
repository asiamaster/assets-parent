package com.dili.assets.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dili.assets.domain.CarTypePublic;
import com.dili.assets.domain.query.CarTypePublicQuery;
import com.dili.assets.mapper.CarTypePublicMapper;
import com.dili.assets.sdk.dto.CarTypeForJmsfDTO;
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
	public String listCarTypePublic(CarTypePublicQuery carTypePublic, boolean b) throws Exception {
		//设置分页信息
		Integer page = carTypePublic.getPage();
		page = (page == null) ? Integer.valueOf(1) : page;
		if(carTypePublic.getRows() != null && carTypePublic.getRows() >= 1) {
			PageHelper.startPage(page, carTypePublic.getRows());
		}
		List<Map<String, Object>> list = getActualDao().listCarTypePublic(carTypePublic);
		long total = list instanceof Page ? ( (Page) list).getTotal() : list.size();
        List results = b ? ValueProviderUtils.buildDataByProvider(carTypePublic, list) : list;
		return new EasyuiPageOutput(Integer.parseInt(String.valueOf(total)), results).toString();
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
	public List<CarTypeForJmsfDTO> listCarTypePublicByBusiness(CarTypePublicQuery carTypePublic) {
		return getActualDao().listCarTypePublicByBusiness(carTypePublic);
	}
}