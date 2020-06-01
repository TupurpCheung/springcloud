package com.tupurp.springcloud.controller;

import com.tupurp.springcloud.entities.CommonResult;
import com.tupurp.springcloud.entities.Payment;
import com.tupurp.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> createPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+ "/payment/create",payment,CommonResult.class);
    }

    /**
     * 返回对象为响应体中数据转化成的对象，基本上可以理解为json
     * */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+ "/payment/get/"+ id,CommonResult.class);
    }


    /**
     * 返回对象为ResponseEntity对象
     * 包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等
     * */
    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return new CommonResult<Payment>(444,"操作失败",null);
        }
    }

    /**
     * 自己实现的轮询功能测试
     * */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(serviceInstanceList == null || serviceInstanceList.size() == 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(serviceInstanceList);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb",String.class);
    }
}