package com.yukong.panda.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAspectJAutoProxy
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = {"com.yukong.panda.user", "com.yukong.panda.common"})
public class PandaUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PandaUserServiceApplication.class, args);
    }
}
