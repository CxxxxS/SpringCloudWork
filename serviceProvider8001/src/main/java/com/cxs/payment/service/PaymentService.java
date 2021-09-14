package com.cxs.payment.service;

import com.cxs.payment.entity.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
