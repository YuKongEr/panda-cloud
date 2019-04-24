package com.yukong.panda.user.controller;

import com.yukong.panda.common.base.controller.BaseController;
import com.yukong.panda.user.model.entity.SysZuulRoute;
import com.yukong.panda.user.model.query.SysZuulRouteQuery;
import com.yukong.panda.user.service.SysZuulRouteService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yukong
 * @date 2019-04-24 11:26
 */
@RestController
@RequestMapping("/route")
@Api(value = "zuul路由controller", tags = {"zuul路由操作接口"})
public class SysZuulRouteController extends BaseController<SysZuulRouteService, SysZuulRouteQuery, SysZuulRoute, Integer> {
}