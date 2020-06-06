package com.tupurp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @description: hystix监控主启动类
 * 启动后访问 http://localhost:9001/hystrix
 * 七色
 * 一圈：大小 颜色
 * 一线：观察流量的峰谷值
 *
 *
 *
 * @author: tupurp
 * @create: 2020-06-07 00:36
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

    public static void main(String[] args){
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}