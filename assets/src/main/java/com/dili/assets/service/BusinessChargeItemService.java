package com.dili.assets.service;

import com.dili.assets.domain.BusinessChargeItem;
import com.dili.assets.domain.ChargeItem;
import com.dili.ss.base.BaseService;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-28 17:14:10.
 */
public interface BusinessChargeItemService extends BaseService<BusinessChargeItem, Long> {

    /**
     * 根据市场及业务查询对应的费用项信息
     * @param marketId   市场ID
     * @param businessType 业务类型
     * @param isEnable   是否已启用，如果为true/false，则会查询费用项本身及业务费用项都为启用/禁用 状态的数据，如果为空，则都会忽略此条件
     */
    List<ChargeItem> listItemByMarketAndBusiness(Long marketId, String businessType, Boolean isEnable);
}