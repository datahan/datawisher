package com.datawisher.jpa.dao.repository;

import com.datawisher.jpa.domain.po.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jim
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
