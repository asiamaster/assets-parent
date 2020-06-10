package com.dili.assets.service.impl;

import com.dili.assets.domain.BusinessChargeItem;
import com.dili.assets.mapper.BusinessChargeItemMapper;
import com.dili.assets.service.BusinessChargeItemService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-28 17:14:10.
 */
@Service
public class BusinessChargeItemServiceImpl extends BaseServiceImpl<BusinessChargeItem, Long> implements BusinessChargeItemService {

    public BusinessChargeItemMapper getActualDao() {
        return (BusinessChargeItemMapper)getDao();
    }
}