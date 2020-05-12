package com.dili.assets.service.impl;

import com.dili.assets.domain.ProductRule;
import com.dili.assets.mapper.ProductRuleMapper;
import com.dili.assets.service.ProductRuleService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-12 10:35:09.
 */
@Service
public class ProductRuleServiceImpl extends BaseServiceImpl<ProductRule, Long> implements ProductRuleService {

    public ProductRuleMapper getActualDao() {
        return (ProductRuleMapper)getDao();
    }
}