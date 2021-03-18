package com.dili.assets.glossary;

/**
 * @author asa.lee
 */
public enum FloorPlanDrawTypeEnum {

    REGULAR("规则图形", 1),
    IRREGULAR("不规则图形", 2);
    private String name;
    private Integer code;

    FloorPlanDrawTypeEnum(String name, Integer code) {
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
