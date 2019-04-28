package com.yukong.panda.gateway.event;

import com.yukong.panda.gateway.router.DynamicRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author: yukong
 * @date: 2018/9/29 17:49
 * @description: 路由刷新事件发布
 */
@Service
public class RefreshRouteService {

    @Autowired
    ApplicationEventPublisher publisher;

    @Autowired
    DynamicRouteLocator dynamicRouteLocator;

    /**
     * 动态路由实现 调用refreshRoute() 发布刷新路由事件
     */
    public void refreshRoute() {
        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(dynamicRouteLocator);
        publisher.publishEvent(routesRefreshedEvent);
    }

}
