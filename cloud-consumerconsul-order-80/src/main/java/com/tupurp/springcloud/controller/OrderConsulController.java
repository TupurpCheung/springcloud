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
public class OrderConsulController {

   @Value("${payment.service.name}")
    private  String PAYMENT_URL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo(Payment payment){
        return restTemplate.getForObject(PAYMENT_URL+ "/payment/consul",String.class);
    }

}