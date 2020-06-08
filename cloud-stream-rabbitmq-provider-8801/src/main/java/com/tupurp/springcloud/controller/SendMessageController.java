package com.tupurp.springcloud.controller;

import com.tupurp.springcloud.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-08 21:51
 */
@RestController
public class SendMessageController {

    @Resource
    private MessageProvider messageProvider;



    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}