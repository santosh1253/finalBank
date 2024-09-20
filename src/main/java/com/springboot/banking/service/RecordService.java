package com.springboot.banking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.banking.entity.Customer;
import com.springboot.banking.entity.Records;
import com.springboot.banking.exception.CustomerNotFoundException;
import com.springboot.banking.exception.InsufficientFundsException;
import com.springboot.banking.exception.MinBalanceException;
import com.springboot.banking.exception.RecordNotFoundException;
import com.springboot.banking.repository.CustomerRepository;
import com.springboot.banking.repository.RecordRepo;

@Service
public class RecordService {
	@Autowired
	private RecordRepo rr;
	
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private CustomerRepository cr;
	
	public Records saveRecordByAccno(Records r,Long accno) throws CustomerNotFoundException, MinBalanceException, InsufficientFundsException
	{
		Customer c=cs.fetchCutomerByAccno(accno);
		// 1 is withdrawl
		if(r.getRecordType()==1)
		{
			double res=c.getBalance()-r.getAmount();
			if(res>=0)
			 c.setBalance(res);
			else
				throw new InsufficientFundsException("InsufficientFunds");
		}
		else if(r.getRecordType()==2)
		{
			c.setBalance(c.getBalance()+r.getAmount());
		}
		r.setCustomer(c);// setting a customer for a transaction
		cs.saveCustomer(c); // statement for updating customer balnc
		r.setTime(LocalDateTime.now());
		return rr.save(r);// saving the transaction persistantly
		
	}
	// Get transaction by TID
	public Records getRecordByTid(Long tid) throws RecordNotFoundException
	{
		return rr.findById(tid).orElseThrow(()->new RecordNotFoundException(tid));
	}
	
	
	public List<Records> get10RecordsByAccno(Long accno)
	{
		return rr.findTop10ByCustomerAccnoOrderByTimeDesc(accno);
	}
	
	
	

}
