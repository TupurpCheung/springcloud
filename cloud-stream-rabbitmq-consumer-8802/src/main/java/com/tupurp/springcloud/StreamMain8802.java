package com.tupurp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-08 22:07
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMain8802 {

    public static void main(String[] args){
        SpringApplication.run(StreamMain8802.class,args);
    }
}