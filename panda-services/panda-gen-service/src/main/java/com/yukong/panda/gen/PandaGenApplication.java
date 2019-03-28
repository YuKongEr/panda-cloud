package com.yukong.panda.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: yukong
 * @date: 2018/11/8 09:23
 */
@ComponentScan(basePackages = {"com.yukong.panda.gen", "com.yukong.panda.common"})
@SpringBootApplication
public class PandaGenApplication {

    public static void main(String[] args) {
        SpringApplication.run(PandaGenApplication.class, args);
    }

}
