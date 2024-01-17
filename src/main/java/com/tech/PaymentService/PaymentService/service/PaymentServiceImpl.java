package com.tech.PaymentService.PaymentService.service;

import com.tech.PaymentService.PaymentService.entity.TransactionalDetails;
import com.tech.PaymentService.PaymentService.model.PaymentMode;
import com.tech.PaymentService.PaymentService.model.PaymentRequest;
import com.tech.PaymentService.PaymentService.model.PaymentResponse;
import com.tech.PaymentService.PaymentService.repository.TransactionalDetailsRepository;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private TransactionalDetailsRepository transactionalDetailsRepository;

    @Override
    public long doPayment(PaymentRequest paymentRequest) {
         log.info("Recording Payment Details");
        TransactionalDetails t= TransactionalDetails.builder()
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentDate(Instant.now())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();
        transactionalDetailsRepository.save(t);
        log.info("Transaction Completed with Id : { }"+ t.getId());
        return t.getId();


    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(String orderId) {
        log.info("In get Payment Details By Order Id");
        TransactionalDetails transactionalDetails=transactionalDetailsRepository.findByOrderId(Long.parseLong(String.valueOf(orderId)));
        PaymentResponse paymentResponse=PaymentResponse.builder()
                .paymentId(transactionalDetails.getId())
                .paymentDate(transactionalDetails.getPaymentDate())
                .orderId(transactionalDetails.getOrderId())
                .paymentMode(PaymentMode.valueOf(transactionalDetails.getPaymentMode()))
                .status(transactionalDetails.getPaymentStatus())
                .amount(transactionalDetails.getAmount()).build();

        return paymentResponse;


    }
}
