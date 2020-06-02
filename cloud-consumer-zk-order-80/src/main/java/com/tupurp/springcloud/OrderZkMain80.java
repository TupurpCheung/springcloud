package com.tupurp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: 订单消费者主启动类
 * @author: tupurp
 * @create: 2020-05-31 21:11
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain80 {

    public static void main(String[] args){
        SpringApplication.run(OrderZkMain80.class,args);
    }
}