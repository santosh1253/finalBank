package com.springboot.banking.exception;

public class InsufficientFundsException extends Exception {

	public InsufficientFundsException(String message)
	{
		super(message);
	}
}
