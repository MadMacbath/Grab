package com.macbeth.algorithm.enumeration;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:9:53
 **/
// 经营类型
public enum ManageType {
    ;
    private String desc;
    private int code;

    ManageType(String desc, int code){
        this.desc = desc;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getDescByCode(int code){
        for (ManageType type :this.values()){
            if (type.getCode() != code) continue;
            return type.desc;
        }
        return null;
    }
}
