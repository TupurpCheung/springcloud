package com.tupurp.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.tupurp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-04 23:01
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    //====服务降级

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("**** result : {}",result);
        return result;
    }


    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Long id){
        String result = paymentService.paymentInfo_timeout(id);
        log.info("**** result : {}",result);
        return result;
    }


    //===服务熔断
    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id){
       String result = paymentService.paymentCircuitBreaker(id);
        log.info("**** result : {}",result);
        return result;
    }
}