package com.datawisher.redisson.demo01.service;

import com.datawisher.redisson.demo01.LockCut;
import com.datawisher.redisson.demo01.domain.vo.PaymentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    @LockCut(value = "lockMethod")
    public void myMethod(PaymentVO paymentVO) {
        log.warn("myMethod running");
    }

}
