package com.tech.PaymentService.PaymentService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {

    private long paymentId;

    private String status;

    private long amount;

    private PaymentMode paymentMode;

    private Instant paymentDate;

    private long orderId;


}
