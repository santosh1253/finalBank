package com.springboot.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.banking.entity.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long>{

}
