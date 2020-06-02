package com.tupurp.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: feign的日志配置
 * @author: tupurp
 * @create: 2020-06-02 23:34
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 完整日志
     * */
    @Bean
    public Logger.Level getLevel(){
        return Logger.Level.FULL;
    }
}