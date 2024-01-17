package com.tech.PaymentService.PaymentService.entity;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="TRANSACTION_DETAILS")
public class TransactionalDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="ORDER_ID")
    private long orderId;
    @Column(name="MODE")
    private String paymentMode;
    @Column(name="REFERENCE_NUMBER")
    private String referenceNumber;
    @Column(name="PAYMENT_DATE")
    private Instant paymentDate;
    @Column(name="PAYMENT_STATUS")
    private String paymentStatus;
    @Column(name="AMOUNT")
    private long amount;

}
