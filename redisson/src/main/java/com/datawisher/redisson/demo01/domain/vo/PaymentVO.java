package com.datawisher.redisson.demo01.domain.vo;

import com.datawisher.redisson.demo01.LockId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentVO {

    @LockId
    private String item;

    private BigDecimal amount;
}
