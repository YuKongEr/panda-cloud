package com.yukong.panda.gateway.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: yukong
 * @date: 2018/11/15 16:50
 */
public interface SysPermissionService {

    /**
     * 判断当前用户是否有权限请求该url
     * @param request
     * @param authentication
     * @return
     */
    Boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
