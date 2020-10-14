package com.capgemini;

public class InvalidCustomerException extends Exception {

	@Override
	public String getMessage() {
		return ("Invalid customer !! Exception thrown");
	}
}
