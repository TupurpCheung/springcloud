package com.tupurp.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 容器bean配置
 * @author: tupurp
 * @create: 2020-05-31 21:24
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //测试自己写的LoadBalancer轮询时，注释掉此注解
    @LoadBalanced //赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}