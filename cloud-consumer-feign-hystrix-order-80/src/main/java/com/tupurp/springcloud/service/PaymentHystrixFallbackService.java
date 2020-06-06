package com.tupurp.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @description: 通配服务降级,消费端（客户端）指定通用的兜底降级方法，那么无论是服务端报错，超时，还是宕机都可以应对
 *
 * @author: tupurp
 * @create: 2020-06-06 22:50
 */
@Component
public class PaymentHystrixFallbackService  implements  PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Long id) {
        return "**** PaymentHystrixFallbackService fall back paymentInfo_ok,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_timeout(Long id) {
        return "**** PaymentHystrixFallbackService fall back paymentInfo_timeout,/(ㄒoㄒ)/~~";
    }
}