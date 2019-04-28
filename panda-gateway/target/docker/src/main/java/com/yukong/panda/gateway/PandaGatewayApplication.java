package com.yukong.panda.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"com.yukong.panda.common", "com.yukong.panda.gateway"})
@EnableZuulProxy
@SpringBootApplication
public class PandaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PandaGatewayApplication.class, args);
	}
}
