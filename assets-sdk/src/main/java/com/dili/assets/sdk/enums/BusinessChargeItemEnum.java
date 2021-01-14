package com.dili.assets.sdk.enums;

import lombok.Getter;

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
        @Getter
        private Integer code;
        /**
         * 类型值
         */
        @Getter
        private String value;
        /**
         * 是否需要重新改类型的数据并填充到相应控件
         */
        @Getter
        private Boolean query;

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

        /**
         * 对比枚举值是否相等
         * @param code
         * @return
         */
        public Boolean equalsToCode(Integer code) {
            return this.getCode().equals(code);
        }
    }

    /**
     * 费用系统科目
     */
    public enum SystemSubjectType {
        默认(1, "其它"),
        开卡工本费(101, "开卡工本费"),
        换卡工本费(102, "换卡工本费"),
        POS充值手续费(103, "POS充值手续费"),
        提现网银手续费(104, "提现网银手续费"),
        定金(201, "定金"),
        保证金(202, "保证金"),
        车辆进门办卡费(301, "车辆进门办卡费")
        ;

        @Getter
        private Integer code;
        @Getter
        private String name;

        SystemSubjectType(int code, String name) {
            this.code = code;
            this.name = name;
        }

        /**
         * 获取某个枚举值实例信息
         *
         * @param code
         * @return
         */
        public static Optional<SystemSubjectType> getInstance(Integer code) {
            for (SystemSubjectType sst : SystemSubjectType.values()) {
                if (sst.getCode().equals(code)) {
                    return Optional.of(sst);
                }
            }
            return Optional.empty();
        }

        /**
         * 对比枚举值是否相等
         * @param code
         * @return
         */
        public Boolean equalsToCode(Integer code) {
            return this.getCode().equals(code);
        }

    }
}
