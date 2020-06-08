package com.tupurp.springcloud.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @description: stream分组消费
 * @author: tupurp
 * @create: 2020-06-08 22:50
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListenerWithGroup {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        log.info("消费者8803，----》接收到的消息：{}，port:{}",message.getPayload() ,serverPort);
    }
}