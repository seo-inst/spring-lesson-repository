package org.kosa.myproject.exception;

public class AccountNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 496512639430645354L;
	public AccountNotFoundException(String message) {
		super(message);
	}
}
