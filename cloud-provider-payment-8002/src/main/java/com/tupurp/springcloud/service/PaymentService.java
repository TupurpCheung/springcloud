package com.tupurp.springcloud.service;

import com.tupurp.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @description: 支付service
 * @author: tupurp
 * @create: 2020-05-31 23:26
 */
public interface PaymentService {
     int create(Payment payment);

     Payment getById(@Param("id") Long id);
}