package com.cxs.springbootWork.service;

import com.cxs.springbootWork.entity.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
