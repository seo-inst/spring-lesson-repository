package org.kosa.myproject.model.member;

public class DuplicateIdException extends Exception {
	private static final long serialVersionUID = -8377737230312965227L;
	public DuplicateIdException(String message) {
		super(message);
	}
}
