package com.tupurp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-08 22:48
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMain8803 {

    public static void main(String[] args){
        SpringApplication.run(StreamMain8803.class,args);
    }
}