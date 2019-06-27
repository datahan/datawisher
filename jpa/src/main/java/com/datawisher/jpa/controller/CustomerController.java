package com.datawisher.jpa.controller;

import com.datawisher.jpa.domain.vo.CustomerVO;
import com.datawisher.jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jim
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Integer> addCustomer(@RequestBody CustomerVO customerVo) {
        int i = customerService.addCustomer(customerVo);
        if (i == 1) {
            return new ResponseEntity<>(i, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/update")
    public ResponseEntity<Integer> updateCustomer(@RequestBody CustomerVO customerVO) {
        int i = customerService.updateCustomer(customerVO);
        if (i == 1) {
            return new ResponseEntity<>(i, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
