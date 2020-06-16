package com.dili.assets.mapper;

import com.dili.assets.domain.BusinessChargeItem;
import com.dili.assets.domain.ChargeItem;
import com.dili.ss.base.MyMapper;

import java.util.List;
import java.util.Map;

public interface BusinessChargeItemMapper extends MyMapper<BusinessChargeItem> {
    /**
     * 根据市场及业务查询对应的费用项信息
     * @param params   参数信息
     */
    List<ChargeItem> listItemByMarketAndBusiness(Map<String,Object> params);

}