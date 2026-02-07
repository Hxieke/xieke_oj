package com.hxk.xiekeojbackendjudgeservice;

import com.hxk.xiekeojbackendjudgeservice.rabbitmq.InitRabbitMq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.hxk")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.hxk.xiekeojbackendserviceclient.service"})
public class XiekeojBackendJudgeServiceApplication {

    public static void main(String[] args) {
        // 初始化消息队列，先注释掉，改用 Bean 的方式初始化消息队列（InitRabbitMqBean.java）
        InitRabbitMq.doInit();
        SpringApplication.run(XiekeojBackendJudgeServiceApplication.class, args);
        System.out.println("勰科的判题模块启动成功！");
    }

}
