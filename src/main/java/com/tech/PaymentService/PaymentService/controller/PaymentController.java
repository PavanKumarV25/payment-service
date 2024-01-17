package com.tech.PaymentService.PaymentService.controller;


import com.tech.PaymentService.PaymentService.model.PaymentRequest;
import com.tech.PaymentService.PaymentService.model.PaymentResponse;
import com.tech.PaymentService.PaymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest)
    {
        return new ResponseEntity<>(paymentService.doPayment(paymentRequest),HttpStatus.OK);
    }

    @GetMapping("/getDetails/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetials(@PathVariable long orderId){
        return new ResponseEntity<>(paymentService.getPaymentDetailsByOrderId(String.valueOf(orderId)),HttpStatus.OK);
    }
}

