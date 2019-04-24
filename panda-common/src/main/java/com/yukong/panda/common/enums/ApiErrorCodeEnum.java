package com.yukong.panda.common.enums;

import com.baomidou.mybatisplus.extension.api.IErrorCode;
import com.baomidou.mybatisplus.extension.enums.ApiErrorCode;

/**
 * @author yukong
 * @date 2019-04-20 18:54
 */
public enum  ApiErrorCodeEnum implements IErrorCode {
    /**
     * 失败
     */
    FAILED(-1, "失败"),
    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 认证失败
     */
    AUTHORIZED_FAILED(-2, "用户名或密码错误");

    private final long code;
    private final String msg;

    ApiErrorCodeEnum(final long code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiErrorCodeEnum fromCode(long code) {
        ApiErrorCodeEnum[] ecs = ApiErrorCodeEnum.values();
        for (ApiErrorCodeEnum ec : ecs) {
            if (ec.getCode() == code) {
                return ec;
            }
        }
        return SUCCESS;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return String.format(" ErrorCode:{code=%s, msg=%s} ", code, msg);
    }
}