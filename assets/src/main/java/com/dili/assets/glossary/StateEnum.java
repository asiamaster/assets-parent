package com.dili.assets.glossary;

public enum StateEnum {

    YES("删除", 1),
    NO("未删除", 0);
    private String name;
    private Integer code;

    StateEnum(String name, Integer code) {
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
