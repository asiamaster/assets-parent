package com.dili.assets.glossary;


public enum AssetsEnum {

    FREE(1, "空闲"),
    RENT(2, "使用中"),
    FIX(2, "维修中"),
    ;

    private String name;
    private Integer code ;

    AssetsEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }


    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
