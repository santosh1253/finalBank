package com.springboot.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.banking.entity.Customer;
import com.springboot.banking.exception.CustomerNotFoundException;
import com.springboot.banking.exception.MinBalanceException;
import com.springboot.banking.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping("/savecustomer")
	public Customer saveCustomer(@RequestBody Customer c) throws MinBalanceException, CustomerNotFoundException {
		return service.saveCustomer(c);

	}

	@GetMapping("/customer/{accno}")
	public Customer getCustomerByAcc(@PathVariable Long accno) throws CustomerNotFoundException {
		return service.fetchCutomerByAccno(accno);
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}

	@PutMapping("/customer")
	public Customer updateCustomerByAcc(@RequestBody Customer customer)
			throws CustomerNotFoundException {
		return service.updateCustomer(customer);
	}

	@DeleteMapping("/customer/{accno}")
	public String deleteCustomerByAcc(@PathVariable Long accno) throws CustomerNotFoundException {
		Long no = service.deleteCustomer(accno);
		return "Customer with id " + no + " deleted";
	}

	@PutMapping("/customer/{accno}/{password}")
	public String updatePassword(@PathVariable Long accno, @PathVariable String password) throws CustomerNotFoundException {
		return service.updatePasswordByAccno(accno, password);
	}

	@PostMapping("/validateCustomer/{accno}/{password}")
	public String validateCustomer(@PathVariable Long accno,@PathVariable String password) throws CustomerNotFoundException
	{
		return service.validateCustomer(accno,password);
	}

}
