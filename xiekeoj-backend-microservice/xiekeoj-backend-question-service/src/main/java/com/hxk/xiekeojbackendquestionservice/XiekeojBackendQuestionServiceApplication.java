package com.hxk.xiekeojbackendquestionservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.hxk.xiekeojbackendquestionservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.hxk")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.hxk.xiekeojbackendserviceclient.service"})
public class XiekeojBackendQuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiekeojBackendQuestionServiceApplication.class, args);
        System.out.println("勰科的题目模块启动成功！");
    }

}
