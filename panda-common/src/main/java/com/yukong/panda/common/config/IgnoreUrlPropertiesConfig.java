package com.yukong.panda.common.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yukong
 * @date: 2018/10/15 15:31
 * @description: 过滤URL属性配置类
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = "ignore")
@Component
public class IgnoreUrlPropertiesConfig {

    private List<String> urls = new ArrayList<>();

    private List<String> client = new ArrayList<>();

}
