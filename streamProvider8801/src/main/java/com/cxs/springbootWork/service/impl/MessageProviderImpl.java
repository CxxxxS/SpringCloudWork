package com.cxs.springbootWork.service.impl;

import com.cxs.springbootWork.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider {

    @Resource
    MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        //通过output这个管道向消息中间件发送消息
        Message<String> message = MessageBuilder.withPayload(serial).build();
        output.send(message);
        System.out.println("*********serial: " + serial);
        return null;
    }
}
