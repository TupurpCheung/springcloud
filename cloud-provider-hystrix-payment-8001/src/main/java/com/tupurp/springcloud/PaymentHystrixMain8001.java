package com.tupurp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-04 22:55
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
//@EnableCircuitBreaker = EnableHystrix
public class PaymentHystrixMain8001 {

    public static void main(String [] args){
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }
}