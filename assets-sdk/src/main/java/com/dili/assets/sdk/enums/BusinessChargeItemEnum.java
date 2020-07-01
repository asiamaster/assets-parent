package com.dili.assets.sdk.enums;

import java.util.Optional;

/**
 * <B>业务费用项相关的枚举定义</B>
 * <B>Copyright:本软件源代码版权归农丰时代科技有限公司及其研发团队所有,未经许可不得任意复制与传播.</B>
 * <B>农丰时代科技有限公司</B>
 *
 * @author yuehongbo
 * @date 2020/6/16 17:15
 */
public class BusinessChargeItemEnum {

    /**
     * 收费项类型
     */
    public enum ChargeType {
        收费(1, "收费", false),
        优惠(2, "优惠", true),
        返点(3, "返点", true),
        ;

        ChargeType(Integer code, String value, Boolean query) {
            this.code = code;
            this.value = value;
            this.query = query;
        }

        /**
         * 类型编码
         */
        private Integer code;
        /**
         * 类型值
         */
        private String value;
        /**
         * 是否需要重新改类型的数据并填充到相应控件
         */
        private Boolean query;

        public Integer getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

        public Boolean getQuery() {
            return query;
        }

        /**
         * 获取某个枚举值实例信息
         *
         * @param code
         * @return
         */
        public static Optional<ChargeType> getInstance(Integer code) {
            for (ChargeType chargeType : ChargeType.values()) {
                if (chargeType.getCode().equals(code)) {
                    return Optional.of(chargeType);
                }
            }
            return Optional.empty();
        }
    }
}
