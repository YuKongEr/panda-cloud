package com.yukong.panda.common.annotation;

import java.lang.annotation.*;

/**
 * @author: yukong
 * @date: 2018/11/14 11:21
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SysLog {

    /**
     * 服务id
     * @return
     */
    String serviceId();

    /**
     * 模块名
     * @return
     */
    String moduleName();

    /**
     * 操作名
     * @return
     */
    String actionName();

}
