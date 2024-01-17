package com.tech.PaymentService.PaymentService.service;

import com.tech.PaymentService.PaymentService.model.PaymentRequest;
import com.tech.PaymentService.PaymentService.model.PaymentResponse;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(String orderId);
}
