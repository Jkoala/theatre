package com.devin.model.dto;
/**
 * User: devin
 * Date: 2020/2/20
 * Time: 21:51
 * Description: No Description
 */
public enum  TheatrePropertiesEnum {
    /*
    * 项目语言
    * */
    THEATRE_LOCALE("theatre_locale");

    private String prop;

    TheatrePropertiesEnum(String prop){
        this.prop = prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getProp(){
        return prop;
    }

}
