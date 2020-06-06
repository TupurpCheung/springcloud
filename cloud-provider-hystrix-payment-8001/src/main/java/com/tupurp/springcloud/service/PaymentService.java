package com.tupurp.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description: hystrix测试
 * @author: tupurp
 * @create: 2020-06-04 22:57
 */
@Service
public class PaymentService {

    /**
     * 正常访问ok的方法
     * */
    public String paymentInfo_OK(Long id){
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id + "\t" + "O(∩_∩)O";
    }


    /**
     * 超时的方法，服务降级使用 this.paymentInfo_timeoutHandler方法
     *
     * */
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "4000")
    })
    public String paymentInfo_timeout(Long id){
        //int i = 10/0;
        int timeout = 8;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName()
                + " paymentInfo_timeout, id: " + id + "\t" + "/(ㄒoㄒ)/~~"
                + " 耗时 "+ timeout + "秒！";
    }

    public String paymentInfo_timeoutHandler(Long id){
        return "线程池： " + Thread.currentThread().getName()
                +  " 8001 系统繁忙或者运行报错, id: " + id + "\t" + "/(ㄒoㄒ)/~~";

    }
}