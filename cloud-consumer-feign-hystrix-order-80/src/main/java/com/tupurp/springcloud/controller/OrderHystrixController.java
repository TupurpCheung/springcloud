package com.tupurp.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tupurp.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-04 23:43
 */
@RestController
@Slf4j
public class OrderHystrixController {


    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("**** result : {}",result);
        return result;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Long id){
        int i = 10/0;
        String result = paymentHystrixService.paymentInfo_timeout(id);
        log.info("**** result : {}",result);
        return result;
    }


    public String paymentInfo_timeoutHandler(Long id){
        return " 我是消费者80，对方支付系统繁忙请稍后再试或当前服务出错 \t" + "( ╯□╰ )";

    }
}