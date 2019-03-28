package com.yukong.panda.gen.model.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: yukong
 * @date: 2018/11/8 15:48
 */
public enum GenTypeEnum {

    IBATIS("ibatis", "1"),
    MYBATIS("mybatis", "2");

    @Getter
    @Setter
    private String key;

    @Getter
    @Setter
    private String value;

    private GenTypeEnum(String key, String  value) {
        this.key = key;
        this.value = value;
    }

}
