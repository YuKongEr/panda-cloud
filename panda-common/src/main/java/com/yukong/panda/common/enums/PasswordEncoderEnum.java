package com.yukong.panda.common.enums;

/**
 * @author yukong
 * @date 2019-04-23 14:15
 */
public enum PasswordEncoderEnum {

    /**
     * bcrypt加密
     */
    BCRYPT("{bcrypt}"),
    /**
     * 明文
     */
    NOOP("{noop}");

    private String value;

    private PasswordEncoderEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
