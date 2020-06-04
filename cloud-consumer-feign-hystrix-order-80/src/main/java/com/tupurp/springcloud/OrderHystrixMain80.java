package com.tupurp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-04 23:39
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
//@EnableHystrix = @EnableCircuitBreaker
public class OrderHystrixMain80 {

    public static void main(String[] args){
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}