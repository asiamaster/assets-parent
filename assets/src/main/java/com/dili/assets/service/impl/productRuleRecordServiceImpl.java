package com.dili.assets.service.impl;

import com.dili.assets.domain.productRuleRecord;
import com.dili.assets.mapper.productRuleRecordMapper;
import com.dili.assets.service.productRuleRecordService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-12 10:35:29.
 */
@Service
public class productRuleRecordServiceImpl extends BaseServiceImpl<productRuleRecord, Long> implements productRuleRecordService {

    public productRuleRecordMapper getActualDao() {
        return (productRuleRecordMapper)getDao();
    }
}