package com.yukong.panda.user.controller;


import com.yukong.panda.common.base.controller.BaseController;
import com.yukong.panda.user.model.entity.SysOauthClientDetails;
import com.yukong.panda.user.model.query.SysOauthClientDetailsQuery;
import com.yukong.panda.user.service.SysOauthClientDetailsService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * oauth2客户端资源认证表 前端控制器
 * </p>
 *
 * @author yukong
 * @since 2018-12-13
 */
@RestController
@RequestMapping("/client")
@Api(value = "oAuth2客户端controller", tags = {"oAuth2客户端操作接口"})
public class SysOauthClientDetailsController extends BaseController<SysOauthClientDetailsService, SysOauthClientDetailsQuery, SysOauthClientDetails, String> {

}
