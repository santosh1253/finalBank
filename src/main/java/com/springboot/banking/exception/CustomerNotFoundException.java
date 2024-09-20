package com.springboot.banking.exception;

public class CustomerNotFoundException extends Exception {
	
   public CustomerNotFoundException(Long accno)
   {
	   super("Customer With "+accno+" not found");
   }
}
