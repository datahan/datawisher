package com.datawisher.redisson.demo01.controller;

import com.datawisher.redisson.demo01.domain.vo.PaymentVO;
import com.datawisher.redisson.demo01.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/myMethod")
    public String myMethod(@RequestBody PaymentVO paymentVO) {
        paymentService.myMethod(paymentVO);
        return "success";
    }
}
