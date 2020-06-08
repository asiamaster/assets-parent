package com.dili.assets.service.impl;

import com.dili.assets.domain.BusinessChargeItem;
import com.dili.assets.domain.ChargeItem;
import com.dili.assets.mapper.BusinessChargeItemMapper;
import com.dili.assets.service.BusinessChargeItemService;
import com.dili.commons.glossary.YesOrNoEnum;
import com.dili.ss.base.BaseServiceImpl;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-28 17:14:10.
 */
@Service
public class BusinessChargeItemServiceImpl extends BaseServiceImpl<BusinessChargeItem, Long> implements BusinessChargeItemService {

    public BusinessChargeItemMapper getActualMapper() {
        return (BusinessChargeItemMapper)getDao();
    }

    @Override
    public List<ChargeItem> listItemByMarketAndBusiness(Long marketId, String businessType, Boolean isEnable) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("marketId", marketId);
        params.put("businessType", businessType);
        if (Objects.nonNull(isEnable)) {
            if (isEnable) {
                params.put("isEnable", YesOrNoEnum.YES.getCode());
            } else {
                params.put("isEnable", YesOrNoEnum.NO.getCode());
            }
        }
        params.put("isDelete", YesOrNoEnum.NO.getCode());
        return getActualMapper().listItemByMarketAndBusiness(params);
    }
}