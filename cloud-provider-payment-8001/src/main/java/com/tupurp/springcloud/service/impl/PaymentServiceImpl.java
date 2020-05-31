package com.tupurp.springcloud.service.impl;

import com.tupurp.springcloud.dao.PaymentDao;
import com.tupurp.springcloud.entities.Payment;
import com.tupurp.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-05-31 23:26
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getById(Long id){
        return paymentDao.getById(id);
    }
}