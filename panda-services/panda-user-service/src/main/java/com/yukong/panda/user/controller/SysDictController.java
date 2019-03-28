package com.yukong.panda.user.controller;

import com.yukong.panda.common.base.controller.BaseController;
import com.yukong.panda.user.model.entity.SysDict;
import com.yukong.panda.user.service.SysDictService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yukong
 * @date 2019-01-23 10:58
 */
@RestController
@RequestMapping("/dict")
@Api(value = "字典controller", tags = {"系统字典操作接口"})
public class SysDictController extends BaseController<SysDictService, SysDict, Integer> {
}
