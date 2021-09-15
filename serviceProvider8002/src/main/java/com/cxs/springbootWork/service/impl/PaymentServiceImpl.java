package com.cxs.springbootWork.service.impl;

import com.cxs.springbootWork.entity.Payment;
import com.cxs.springbootWork.dao.PaymentDao;
import com.cxs.springbootWork.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
