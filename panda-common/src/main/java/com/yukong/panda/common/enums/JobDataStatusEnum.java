package com.yukong.panda.common.enums;

/**
 * @author yukong
 * @date 2018/10/9 14:35
 * @description job任务状态枚举
 */
public enum JobDataStatusEnum {

    /**
     * 运行中
     */
    UP(0, "运行"),

    /**
     * 停止
     */
    STOP(1,"停止");


    private Integer code;

    private String message;

    JobDataStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
