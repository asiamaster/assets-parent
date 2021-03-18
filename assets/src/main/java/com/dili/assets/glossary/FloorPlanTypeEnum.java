package com.dili.assets.glossary;

/**
 * @author asa.lee
 */
public enum FloorPlanTypeEnum {

    BASE("背景图", 1),
    BOOTH("摊位图", 2);
    private String name;
    private Integer code;

    FloorPlanTypeEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
