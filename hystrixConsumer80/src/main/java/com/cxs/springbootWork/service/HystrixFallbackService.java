package com.cxs.springbootWork.service;

import org.springframework.stereotype.Component;

@Component
public class HystrixFallbackService implements HystrixServer{
    @Override
    public String getMsgViaId(Integer id) {
        return "服务器出现错误；getMsgViaId: " + id;
    }

    @Override
    public String getMsgOfTimeout(Integer id) {
        return "服务器出现错误；getMsgOfTimeout: " + id;
    }
}
