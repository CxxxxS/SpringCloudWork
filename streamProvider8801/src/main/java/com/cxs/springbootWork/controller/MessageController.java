package com.cxs.springbootWork.controller;

import com.cxs.springbootWork.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageController {

    @Resource
    private MessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMsg() {
        return messageProvider.send();
    }
}
