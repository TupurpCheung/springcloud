package com.tupurp.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @description: hystrix测试
 * @author: tupurp
 * @create: 2020-06-04 22:57
 */
@Service
public class PaymentService {

    ////服务降级

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

    ///////服务熔断

    /**
     *
     * 涉及到断路器的三个重要参数：快照时间窗、请求总数阀值、错误百分比阀值
     * 1：快照时间窗：断路器确定是否打开，需要统计一些请求和错误数据，而统计的时间范围就是快照时间窗，默认为最近的10秒
     * 2：请求的总数阀值：在快照时间窗内，必须满足请求总数阀值才有资格熔断，默认为20，意味着在10s内，如果hystrix命令调用的次数不足20次
     * 即使所有的请求都超时或者其他原因失败，断路器都不会打开
     * 3：错误百分比阀值：当在快照时间内 错误的次数/请求总数 * 100% 大于设定的阀值，断路器将会被打开，默认阀值为50%
     *
     * */
    //com.netflix.hystrix.HystrixCommandProperties
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",
        commandProperties = {
            @HystrixProperty(name ="circuitBreaker.enabled",value = "true"), //是否启用断路器
            @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少会有熔断
            @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds",value = "10000") //熔断时间

        }
    )
    public String paymentCircuitBreaker(@PathVariable("id") Long id){
        if(id < 0l){
            throw new RuntimeException("**** id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Long id){
        return "id 不能为负数，请稍后再试，(*^_^*) id：" + id;
    }
}