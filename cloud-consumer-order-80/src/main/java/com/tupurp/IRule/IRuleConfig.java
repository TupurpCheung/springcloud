package com.tupurp.IRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: ribbon核心组件IRule实现选择
 * @author: tupurp
 * @create: 2020-06-02 00:39
 */
@Configuration
public class IRuleConfig {

    @Bean
    public IRule getIRule(){
        return new RandomRule(); //自定义为随机（出厂为轮询）
    }
}