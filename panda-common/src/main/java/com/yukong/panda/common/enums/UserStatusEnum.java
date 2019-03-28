package com.yukong.panda.common.enums;

/**
 * @author: yukong
 * @date: 2018/10/9 14:35
 * @description: 用户状态枚举
 */
public enum  UserStatusEnum {

    /**
     * 正常
     */
    NORMAL("0", "正常"),

    /**
     * 锁定
     */
    LOCK("1","锁定");


    private String code;

    private String message;

    UserStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
