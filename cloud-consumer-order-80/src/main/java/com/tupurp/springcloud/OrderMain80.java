package com.tupurp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: 订单消费者主启动类
 * @author: tupurp
 * @create: 2020-05-31 21:11
 */

@SpringBootApplication
@EnableEurekaClient
public class OrderMain80 {

    public static void main(String[] args){
        SpringApplication.run(OrderMain80.class,args);
    }
}