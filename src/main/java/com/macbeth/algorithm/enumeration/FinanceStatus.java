package com.macbeth.algorithm.enumeration;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:10:19
 **/
// 融资情况
public enum FinanceStatus {
    ;
    private String desc;
    private int code;

    FinanceStatus(String desc, int code){
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
        for (FinanceStatus type :this.values()){
            if (type.getCode() != code) continue;
            return type.desc;
        }
        return null;
    }
}
