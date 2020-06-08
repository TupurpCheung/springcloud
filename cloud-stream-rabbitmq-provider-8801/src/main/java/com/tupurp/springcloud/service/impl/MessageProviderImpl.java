package com.tupurp.springcloud.service.impl;

import com.tupurp.springcloud.service.MessageProvider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @description: 消息发送接口实现（与rabbitmq打交道）
 * @author: tupurp
 * @create: 2020-06-08 21:45
 */

@EnableBinding(Source.class) //定义消息的推送管道源
@Slf4j
public class MessageProviderImpl implements MessageProvider {

    @Resource
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("**** serial: {}",serial);
        return serial;
    }
}