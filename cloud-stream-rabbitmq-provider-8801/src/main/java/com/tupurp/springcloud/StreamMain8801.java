package com.tupurp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-08 21:40
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMain8801 {
    public static void main(String[] args){
        SpringApplication.run(StreamMain8801.class,args);
    }
}