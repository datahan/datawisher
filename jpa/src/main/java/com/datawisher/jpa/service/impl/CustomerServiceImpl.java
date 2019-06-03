package com.datawisher.jpa.service.impl;

import com.datawisher.jpa.dao.repository.CustomerRepository;
import com.datawisher.jpa.domain.po.Customer;
import com.datawisher.jpa.domain.vo.CustomerVO;
import com.datawisher.jpa.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jim
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public int addCustomer(CustomerVO customerVO) {

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerVO, customer);
        customerRepository.save(customer);

        Customer customer1 = new Customer();
        BeanUtils.copyProperties(customerVO, customer1);
        customer1.setAge(customer.getAge() + 2);
        float i = 1/0;
        customerRepository.save(customer1);

        return 1;
    }
}
