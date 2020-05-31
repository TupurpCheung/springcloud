package com.tupurp.springcloud.controller;

import com.tupurp.springcloud.entities.CommonResult;
import com.tupurp.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description: 订单controller
 * @author: tupurp
 * @create: 2020-05-31 21:25
 */
@RestController
@Slf4j
public class OrderController {

   @Value("${payment.service.name}")
    private  String PAYMENT_URL;
    //private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> createPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+ "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+ "/payment/get/"+ id,CommonResult.class);
    }
}