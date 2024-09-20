package com.springboot.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.banking.entity.Records;

@Repository
public interface RecordRepo extends JpaRepository<Records,Long>{

	List<Records> findTop10ByCustomerAccnoOrderByTimeDesc(Long accno);
	
	//private Customer customer;
	//private 
}
