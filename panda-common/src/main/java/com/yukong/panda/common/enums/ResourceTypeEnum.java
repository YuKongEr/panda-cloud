package com.yukong.panda.common.enums;

/**
 * @author: yukong
 * @date: 2018/10/17 16:03
 * @description: 资源类型枚举
 */
public enum  ResourceTypeEnum {
    MENU("0", "菜单"),
    BUTTON("1","按钮");


    private String code;

    private String message;

    ResourceTypeEnum(String code, String message) {
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
