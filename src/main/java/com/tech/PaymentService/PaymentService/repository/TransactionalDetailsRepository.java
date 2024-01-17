package com.tech.PaymentService.PaymentService.repository;

import com.tech.PaymentService.PaymentService.entity.TransactionalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionalDetailsRepository extends JpaRepository<TransactionalDetails,Long> {
    TransactionalDetails findByOrderId(long orderId);
}
