package com.springboot.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.banking.entity.Records;
import com.springboot.banking.exception.CustomerNotFoundException;
import com.springboot.banking.exception.InsufficientFundsException;
import com.springboot.banking.exception.MinBalanceException;
import com.springboot.banking.exception.RecordNotFoundException;
import com.springboot.banking.service.RecordService;

@RestController
public class RecordsController {
	@Autowired
	private RecordService service;

	// Saving a record
	@PostMapping("/record/{accno}")
	public Records saveRecord(@RequestBody Records r, @PathVariable Long accno)
			throws CustomerNotFoundException, MinBalanceException, InsufficientFundsException {
		return service.saveRecordByAccno(r, accno);
	}

	// Get a record by tid
	@GetMapping("/record/{tid}")
	public Records getRecord(@PathVariable Long tid) throws RecordNotFoundException {
		return service.getRecordByTid(tid);
	}

	// Get top 10 records
	@GetMapping("/allrecords/{accno}")
	public List<Records> getRecordsByAccno(@PathVariable Long accno) throws RecordNotFoundException {
		return service.get10RecordsByAccno(accno);
	}

}
