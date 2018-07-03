package com.macbeth.algorithm.enumeration;

/**
 * author:macbeth
 * Date:2018/7/3
 * Time:9:53
 **/
public enum JobType {
    PULL_TIME("全职",1),PART_TIME("兼职",2);

    private String desc;
    private int code;

    JobType(String desc,int code){
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
        for (JobType type :this.values()){
            if (type.getCode() != code) continue;
            return type.desc;
        }
        return null;
    }
}
