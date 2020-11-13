package com.exception;

public class EmployeeNotFoundException extends Exception{
	
	public EmployeeNotFoundException(){
		super("Emoloyee does not exists");
	}

}
