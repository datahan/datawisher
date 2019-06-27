package com.datawisher.jpa.service;

import com.datawisher.jpa.domain.vo.CustomerVO;

public interface CustomerService {

    int addCustomer(CustomerVO customerVO);

    int updateCustomer(CustomerVO customerVO);
}
