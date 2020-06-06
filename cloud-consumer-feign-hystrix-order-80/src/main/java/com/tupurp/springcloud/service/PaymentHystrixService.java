package com.tupurp.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * feign的接口，测试hystrix
 * 并指定兜底的服务降级实现类
 * feign底层依赖ribbon，feign实现了动态代理拼接Http请求
 * 而ribbon将eureka注册中的数据缓存到了本地，即使eureka服务注册中心挂掉，在一定时间内也可以依靠本地缓存找到服务接口实现调用
 * */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Long id);


    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_timeout(@PathVariable("id") Long id);
}
