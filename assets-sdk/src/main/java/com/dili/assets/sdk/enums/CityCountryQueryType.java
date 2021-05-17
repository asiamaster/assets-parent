package com.dili.assets.sdk.enums;

public enum CityCountryQueryType {
    //国内
    INTERNAL(1),
    //国外
    ABROAD(2),
    //国内和国外
    INTERNAL_ABROAD(3);

    CityCountryQueryType(Integer value) {
        this.value = value;
    }

    private Integer value;

    public Integer getValue() {
        return value;
    }
}
