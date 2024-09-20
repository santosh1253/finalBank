package com.springboot.banking.exception;

public class RecordNotFoundException extends Exception{

	public RecordNotFoundException(Long tid)
	{
		super("Record with Tid "+tid+" Not Found" );
	}
}
