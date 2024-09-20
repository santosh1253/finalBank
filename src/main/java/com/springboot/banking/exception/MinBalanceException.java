package com.springboot.banking.exception;

public class MinBalanceException extends Exception {

	public MinBalanceException()
	{
		super("The Minimum balance is 1000 INR to register an account");
	}
}
