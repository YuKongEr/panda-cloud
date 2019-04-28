package com.yukong.panda.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: yukong
 * @date: 2018/11/30 16:45
 * 消息发送中心 处理短信发送 邮件发送
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.yukong.panda.message", "com.yukong.panda.common"})
public class PandaMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PandaMessageApplication.class, args);
    }

}
