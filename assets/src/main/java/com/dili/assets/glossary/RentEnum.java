package com.dili.assets.glossary;

public enum RentEnum {

    freeze("冻结", 1),
    rent("出粗", 0);
    private String name;
    private Integer code;

    RentEnum(String name, Integer code) {
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
