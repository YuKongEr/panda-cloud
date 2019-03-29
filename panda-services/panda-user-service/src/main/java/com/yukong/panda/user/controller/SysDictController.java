package com.yukong.panda.user.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.yukong.panda.common.base.controller.BaseController;
import com.yukong.panda.user.model.entity.SysDict;
import com.yukong.panda.user.model.query.SysDictQuery;
import com.yukong.panda.user.service.SysDictService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yukong
 * @date 2019-01-23 10:58
 */
@RestController
@RequestMapping("/dict")
@Api(value = "字典controller", tags = {"系统字典操作接口"})
public class SysDictController extends BaseController<SysDictService, SysDictQuery, SysDict, Integer> {

    @GetMapping("/top/name")
    public R<List<SysDict>> getTopDictList(@RequestParam String name) {
        return R.ok(baseService.getTopDictListByDesc(name));
    }

}
