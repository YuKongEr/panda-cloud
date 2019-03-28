package com.yukong.panda.common.enums;

import lombok.Getter;

/**
 * @author: yukong
 * @date: 2018/12/14 14:53
 */
public enum  SmsTemplateEnum {

    /**
     * 腾讯云
     */
    LOGIN_CODE("程序咖啡厅", "238684");

    @Getter
    String signName;

    @Getter
    String tempalte;

    private SmsTemplateEnum(String signName, String tempalte) {
        this.signName = signName;
        this.tempalte = tempalte;
    }
}
