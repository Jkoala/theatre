package com.devin.model.enums;


/**
 * @author: simpl
 * @date: 2020/2/21
 * @time: 10:46
 * @description:
 */
public enum TrueFalseEnum {

    /*
    * 真
    * */

    TRUE("true"),

    /*
    * 假
    * */

    FLASE("false");

    private String desc;

    TrueFalseEnum(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return desc;
    }
}
