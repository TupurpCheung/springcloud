package com.tupurp.springcloud.controller;

import com.tupurp.springcloud.entities.CommonResult;
import com.tupurp.springcloud.entities.Payment;
import com.tupurp.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-02 22:37
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/consumer/payment/feign/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }


    /**
     * openFeign超时测试，默认一秒
     *
     * */
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String getPaymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
}