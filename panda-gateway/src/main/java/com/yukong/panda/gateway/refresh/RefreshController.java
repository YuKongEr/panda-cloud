package com.yukong.panda.gateway.refresh;

import com.yukong.panda.gateway.event.RefreshRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yukong
 * @date: 2018/9/29 18:18
 * @description: 刷新zuul路由
 */
@RestController
public class RefreshController {

    @Autowired
    private RefreshRouteService refreshRouteService;

    @GetMapping("/refresh")
    public String refresh() {
        refreshRouteService.refreshRoute();
        return "refresh";
    }

}
