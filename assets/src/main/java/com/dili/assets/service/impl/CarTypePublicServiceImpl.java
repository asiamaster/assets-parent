package com.dili.assets.service.impl;

import com.dili.assets.domain.CarTypePublic;
import com.dili.assets.mapper.CarTypePublicMapper;
import com.dili.assets.service.CarTypePublicService;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.domain.EasyuiPageOutput;
import com.dili.ss.metadata.ValueProviderUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;

import org.springframework.stereotype.Service;

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
	public String listCarTypePublic(CarTypePublic carTypePublic, boolean b) throws Exception {
		//设置分页信息
		Integer page = carTypePublic.getPage();
		page = (page == null) ? Integer.valueOf(1) : page;
		if(carTypePublic.getRows() != null && carTypePublic.getRows() >= 1) {
			//为了线程安全,请勿改动下面两行代码的顺序
			PageHelper.startPage(page, carTypePublic.getRows());
		}
		List<CarTypePublic> list = getActualDao().listCarTypePublic(carTypePublic);
		long total = list instanceof Page ? ( (Page) list).getTotal() : list.size();
        List results = b ? ValueProviderUtils.buildDataByProvider(carTypePublic, list) : list;
		return new EasyuiPageOutput(Integer.parseInt(String.valueOf(total)), results).toString();
	}
}