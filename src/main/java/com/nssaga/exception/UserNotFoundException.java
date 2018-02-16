/**
 * 
 */
package com.nssaga.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 414300793479111959L;

	public UserNotFoundException(String msg) {
		super(msg);
	}
}
