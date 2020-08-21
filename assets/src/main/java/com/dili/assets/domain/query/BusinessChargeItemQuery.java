package com.dili.assets.domain.query;

import com.dili.assets.domain.BusinessChargeItem;
import com.dili.ss.domain.annotation.Operator;

import javax.persistence.Column;
import java.util.List;

/**
 * 业务费用项查询扩展
 * @author yuehongbo
 * @Copyright 本软件源代码版权归农丰时代科技有限公司及其研发团队所有, 未经许可不得任意复制与传播.
 * @date 2020/8/13 16:22
 */
public class BusinessChargeItemQuery extends BusinessChargeItem {

    /**
     * ID 数据集
     */
    @Column(name = "`id`")
    @Operator(Operator.IN)
    private List<Long> idList;
}
