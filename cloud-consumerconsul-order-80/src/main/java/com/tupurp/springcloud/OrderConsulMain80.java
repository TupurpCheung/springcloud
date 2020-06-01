package com.tupurp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-01 23:05
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 {

    public  static  void main(String[] args){
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}