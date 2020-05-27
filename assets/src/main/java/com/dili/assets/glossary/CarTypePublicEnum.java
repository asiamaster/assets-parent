package com.dili.assets.glossary;


public enum CarTypePublicEnum {

    YES(1, "是"),
    NO(2, "否"),
    ;

    private String name;
    private Integer code;

    CarTypePublicEnum(Integer code, String name){
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
